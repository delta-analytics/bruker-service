package deltaanalytics.bruker.hardware;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.entity.BrukerStateEnum;
import deltaanalytics.bruker.data.entity.MeasureReference;
import deltaanalytics.bruker.data.entity.MeasureSample;
import deltaanalytics.bruker.data.repository.BrukerParametersRepository;
import deltaanalytics.bruker.data.repository.MeasureReferenceRepository;
import deltaanalytics.bruker.data.repository.MeasureSampleRepository;
import deltaanalytics.bruker.hardware.commands.*;
import deltaanalytics.bruker.hardware.util.MeasureSampleResultParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

@Component
public class CommandRunner {
    private Logger LOGGER = LoggerFactory.getLogger(CommandRunner.class);
    private MeasureReferenceRepository measureReferenceRepository;
    private BrukerParametersRepository brukerParametersRepository;
    private MeasureSampleRepository measureSampleRepository;
    private String host;
    private int port;

    public String getVersion() throws Exception {
        LOGGER.info("getVersion");
        return run(new GetVersionCommand().build(host, port))[0];
    }

    public void measureReference() {
        MeasureReference measureReference = new MeasureReference();
        BrukerParameters currentDefaults = brukerParametersRepository.findByCurrentDefaultTrue();
        try {
            LOGGER.info("measureReference");
            measureReference.setBrukerStateEnum(BrukerStateEnum.QUEUED);
            measureReference.setBrukerParameters(currentDefaults);
            measureReferenceRepository.save(measureReference);
            run(new MeasureReferenceCommand().build(host, port, currentDefaults));
            measureReference.setBrukerStateEnum(BrukerStateEnum.FINISHED);
            measureReferenceRepository.save(measureReference);
        } catch (Exception e) {
            measureReference.setBrukerStateEnum(BrukerStateEnum.FINISHED_WITH_ERRORS);
            measureReference.setError(getStackTrace(e));
            measureReference.setFinishedAt(LocalDateTime.now());
            measureReferenceRepository.save(measureReference);
            throw new RuntimeException(e);
        }
    }

    public void measureSample() {
        MeasureSample measureSample = new MeasureSample();
        BrukerParameters currentDefaults = brukerParametersRepository.findByCurrentDefaultTrue();
        try {
            LOGGER.info("measureSample");
            measureSample.setBrukerParameters(currentDefaults);
            measureSample.setBrukerStateEnum(BrukerStateEnum.QUEUED);
            measureSampleRepository.save(measureSample);
            measureSample.setBrukerStateEnum(BrukerStateEnum.RUNNING);
            measureSampleRepository.save(measureSample);
            String[] brukerResult = run(new MeasureSampleCommand().build(host, port, currentDefaults));
            MeasureSampleCommandResult measureSampleCommandResult = new MeasureSampleCommandResult(brukerResult);
            LOGGER.info("saveAs");
            currentDefaults.setDAP(measureSampleCommandResult.getPath());
            currentDefaults.setSAN(measureSampleCommandResult.getFileName());
            LOGGER.info(currentDefaults.getDAP());
            LOGGER.info(currentDefaults.getSAN());
            currentDefaults.setSAN(measureSampleCommandResult.getFileName());
            measureSample.setFilename(measureSampleCommandResult.getPath() + File.separator + measureSampleCommandResult.getFileName());
            run(new SaveAsCommand().build(host, currentDefaults, measureSampleCommandResult.getFileId()));
            measureSample.setMeasureSampleResults(new MeasureSampleResultParser().parse(currentDefaults.getDAP(), currentDefaults.getSAN() + ".dpt"));
            measureSampleRepository.save(measureSample);
            //jueke Temp und Pressure speichern / mitteln
            LOGGER.info("unload");
            run(new UnloadCommand().build(host, measureSampleCommandResult.getFileId()));
            measureSample.setBrukerStateEnum(BrukerStateEnum.FINISHED);
            measureSampleRepository.save(measureSample);
        } catch (Exception e) {
            measureSample.setBrukerStateEnum(BrukerStateEnum.FINISHED_WITH_ERRORS);
            measureSample.setError(getStackTrace(e));
            measureSampleRepository.save(measureSample);
            throw new RuntimeException(e);
        } finally {
            measureSample.setFinishedAt(LocalDateTime.now());
        }

    }

    private String[] run(String encodedCommand) throws Exception {
        LOGGER.info(encodedCommand);
        String withoutPathSpaces = encodedCommand.replaceAll("\\s\\\\", "\\");
        Socket s = new Socket(host, port);
        OutputStream theOutput = s.getOutputStream();
        PrintWriter pw = new PrintWriter(theOutput, false);
        LOGGER.info(withoutPathSpaces);
        pw.write("GET " + withoutPathSpaces + " HTTP/1.0\r\n");
        pw.write("Accept: text/plain, text/html, text/*\r\n");
        pw.write("\r\n");
        pw.flush();
        InputStream in = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder stringBuilder = new StringBuilder();
        LOGGER.info("wait for response");
        String line;
        while ((line = br.readLine()) != null) {
            LOGGER.info("Bruker Response line => " + line);
            stringBuilder.append(line).append(" ");
        }
        LOGGER.info(stringBuilder.toString());
        String[] result = stringBuilder.toString().split(" ");
        handlePossibleErrorAndThrowRuntimeExceptionIfNecessary(result);
        return result;
    }

    private void handlePossibleErrorAndThrowRuntimeExceptionIfNecessary(String[] result) {
        if (result[0].equals("Error")) {
            String errorResult = "";
            for (String partOfResult : result) {
                errorResult += partOfResult + " ";
            }
            throw new RuntimeException("Result from Bruker contains Error! \n" + errorResult);
        }
    }

    private String getStackTrace(final Throwable throwable) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

    @Autowired
    public void setMeasureReferenceRepository(MeasureReferenceRepository measureReferenceRepository) {
        this.measureReferenceRepository = measureReferenceRepository;
    }

    @Autowired
    public void setBrukerParametersRepository(BrukerParametersRepository brukerParametersRepository) {
        this.brukerParametersRepository = brukerParametersRepository;
    }

    @Autowired
    public void setMeasureSampleRepository(MeasureSampleRepository measureSampleRepository) {
        this.measureSampleRepository = measureSampleRepository;
    }

    @Value("${hardware.host}")
    public void setHost(String host) {
        this.host = host;
    }

    @Value("${hardware.port}")
    public void setPort(int port) {
        this.port = port;
    }
}
