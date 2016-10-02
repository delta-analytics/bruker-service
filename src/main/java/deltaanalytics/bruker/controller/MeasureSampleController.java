package deltaanalytics.bruker.controller;

import com.fasterxml.jackson.annotation.JsonView;
import deltaanalytics.bruker.data.entity.MeasureSample;
import deltaanalytics.bruker.data.entity.View;
import deltaanalytics.bruker.data.repository.MeasureSampleRepository;
import deltaanalytics.bruker.hardware.CommandRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Profile({"production", "test"})
@RestController
public class MeasureSampleController {
    private Logger LOGGER = LoggerFactory.getLogger(MeasureSampleController.class);
    private CommandRunner commandRunner;
    private MeasureSampleRepository measureSampleRepository;

    @RequestMapping(value = "/measureSample", method = RequestMethod.POST)
    public void measureSample() {
        LOGGER.info("measureSample");
        commandRunner.measureSample();
        LOGGER.info("measureSample finished");
    }

    @JsonView(View.SmallSummary.class)
    @RequestMapping(value = "/getMeasuredSamples", method = RequestMethod.GET)
    public List<MeasureSample> measuredSamples() {
        LOGGER.info("all measuredSamples");
        List<MeasureSample> all = measureSampleRepository.findAll();
        LOGGER.info("all measuredSamples in DB " + all.size());
        return all;
    }

    @RequestMapping(value = "/getMeasuredSamples/{id}")
    public MeasureSample getMeasuredSample(@PathVariable long id) {
        LOGGER.info("measuredSample " + id);
        return measureSampleRepository.findOne(id);
    }

    @Autowired
    public void setCommandRunner(CommandRunner commandRunner) {
        this.commandRunner = commandRunner;
    }


    @Autowired
    public void setMeasureSampleRepository(MeasureSampleRepository measureSampleRepository) {
        this.measureSampleRepository = measureSampleRepository;
    }
}
