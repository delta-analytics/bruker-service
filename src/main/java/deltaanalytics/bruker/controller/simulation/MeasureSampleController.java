package deltaanalytics.bruker.controller.simulation;

import deltaanalytics.bruker.data.entity.BrukerStateEnum;
import deltaanalytics.bruker.data.entity.MeasureSample;
import deltaanalytics.bruker.data.entity.MeasureSampleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Profile("simulation")
@RestController
public class MeasureSampleController {
    private Logger LOGGER = LoggerFactory.getLogger(MeasureReferenceController.class);
    private BrukerParameterWrapper brukerParameterWrapper;
    private List<MeasureSample> measureSamples = new ArrayList<>();

    @RequestMapping(value = "/measureSample", method = RequestMethod.POST)
    public void measureSample() {
        LOGGER.info("measureSample");
        MeasureSample measureSample = new MeasureSample();
        measureSample.setFilename("filename");
        measureSample.setId(new Random().nextLong());
        measureSample.setCreatedAt(LocalDateTime.now());
        measureSample.setBrukerStateEnum(BrukerStateEnum.FINISHED);
        measureSample.setBrukerParameters(brukerParameterWrapper.getBrukerParameters());
        List<MeasureSampleResult> measureSampleResults = new ArrayList<>();
        MeasureSampleResult measureSampleResult = new MeasureSampleResult();
        measureSampleResult.setId(new Random().nextLong());
        measureSampleResult.setFirstValue(new Random().nextDouble());
        measureSampleResult.setSecondValue(new Random().nextDouble());
        measureSampleResult.setMeasureSample(measureSample);
        measureSampleResults.add(measureSampleResult);
        measureSample.setMeasureSampleResults(measureSampleResults);
        measureSamples.add(measureSample);
        LOGGER.info("measureSample finished");
    }

    @RequestMapping(value = "/measureSamples", method = RequestMethod.GET)
    public List<MeasureSample> measureSamples() {
        LOGGER.info("measureSamples in DB " + measureSamples().size());
        return measureSamples;
    }

    @RequestMapping(value = "/measureSamples/{id}")
    public MeasureSample getMeasureSample(@PathVariable long id) {
        LOGGER.info("getMeasureSample " + id);
        MeasureSample result = null;
        for (MeasureSample measureSample : measureSamples) {
            if(measureSample.getId() == id){
                result = measureSample;
                break;
            }
        }
        return result;
    }
    @Autowired
    public void setBrukerParameterWrapper(BrukerParameterWrapper brukerParameterWrapper) {
        this.brukerParameterWrapper = brukerParameterWrapper;
    }
}
