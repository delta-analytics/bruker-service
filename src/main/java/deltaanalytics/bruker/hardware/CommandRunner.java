package deltaanalytics.bruker.hardware;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.entity.BrukerStateEnum;
import deltaanalytics.bruker.data.entity.MeasureReference;
import deltaanalytics.bruker.data.entity.MeasureSample;
import deltaanalytics.bruker.data.repository.MeasureReferenceRepository;
import deltaanalytics.bruker.data.repository.MeasureSampleRepository;
import deltaanalytics.bruker.hardware.commands.*;
import deltaanalytics.bruker.hardware.util.MeasureSampleResultParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class CommandRunner {
    private Logger LOGGER = LoggerFactory.getLogger(CommandRunner.class);

    public String getVersion(String host, int port) throws Exception {
        LOGGER.info("getVersion");
        return run(host, port, new GetVersionCommand().build(host, port))[0];
    }

    public void measureReference(String host, int port, BrukerParameters brukerParameters) {
        MeasureReference measureReference = new MeasureReference();
        MeasureReferenceRepository measureReferenceRepository = new MeasureReferenceRepository();
        try {
            LOGGER.info("measureReference");
            measureReference.setBrukerStateEnum(BrukerStateEnum.QUEUED);
            measureReference.setBrukerParameters(brukerParameters);
            measureReferenceRepository.createOrUpdate(measureReference);
            run(host, port, new MeasureReferenceCommand().build(host, port, brukerParameters));
            measureReference.setBrukerStateEnum(BrukerStateEnum.FINISHED);
            measureReferenceRepository.createOrUpdate(measureReference);
        } catch (Exception e) {
            measureReference.setBrukerStateEnum(BrukerStateEnum.FINISHED_WITH_ERRORS);
            measureReference.setError(getStackTrace(e));
            measureReferenceRepository.createOrUpdate(measureReference);
            throw new RuntimeException(e);
        }
    }

    public void measureSample(String host, int port, BrukerParameters brukerParameters) {
        MeasureSample measureSample = new MeasureSample();
        MeasureSampleRepository measureSampleRepository = new MeasureSampleRepository();
        try {
            LOGGER.info("measureSample");
            measureSample.setBrukerParameters(brukerParameters);
            measureSample.setBrukerStateEnum(BrukerStateEnum.QUEUED);
            measureSampleRepository.createOrUpdate(measureSample);
            measureSample.setBrukerStateEnum(BrukerStateEnum.RUNNING);
            measureSampleRepository.createOrUpdate(measureSample);
            String[] brukerResult = run(host, port, new MeasureSampleCommand().build(host, port, brukerParameters));
            MeasureSampleCommandResult measureSampleCommandResult = new MeasureSampleCommandResult(brukerResult);
            LOGGER.info("saveAs");
            brukerParameters.setDAP(measureSampleCommandResult.getPath());
            brukerParameters.setSAN(measureSampleCommandResult.getFileName());
            LOGGER.info(brukerParameters.getDAP());
            LOGGER.info(brukerParameters.getSAN());
            brukerParameters.setSAN(measureSampleCommandResult.getFileName());
            run(host, port, new SaveAsCommand().build(host, brukerParameters, measureSampleCommandResult.getFileId()));
            measureSample.setMeasureSampleResults(new MeasureSampleResultParser().parse(brukerParameters.getDAP(), brukerParameters.getSAN()));
            measureSampleRepository.createOrUpdate(measureSample);
            LOGGER.info("unload");
            run(host, port, new UnloadCommand().build(host, measureSampleCommandResult.getFileId()));
            measureSample.setBrukerStateEnum(BrukerStateEnum.FINISHED);
            measureSampleRepository.createOrUpdate(measureSample);
        } catch (Exception e) {
            measureSample.setBrukerStateEnum(BrukerStateEnum.FINISHED_WITH_ERRORS);
            measureSample.setError(getStackTrace(e));
            measureSampleRepository.createOrUpdate(measureSample);
            throw new RuntimeException(e);
        }

    }

    private String[] run(String host, int port, String encodedCommand) throws Exception {
        Socket s = new Socket(host, port);
        OutputStream theOutput = s.getOutputStream();
        PrintWriter pw = new PrintWriter(theOutput, false);
        LOGGER.info(encodedCommand);
        pw.write("GET " + encodedCommand + " HTTP/1.0\r\n");
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
}