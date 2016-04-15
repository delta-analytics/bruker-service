package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.data.entity.MeasureReference;
import deltaanalytics.bruker.data.repository.MeasureReferenceRepository;
import deltaanalytics.bruker.hardware.CommandRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Profile({"production", "test"})
@RestController
public class MeasureReferenceController {
    private Logger LOGGER = LoggerFactory.getLogger(MeasureReferenceController.class);
    private CommandRunner commandRunner;
    private MeasureReferenceRepository measureReferenceRepository;

    @RequestMapping(value = "/measureReference", method = RequestMethod.POST)
    public void measureReference() {
        LOGGER.info("measureReference");
        commandRunner.measureReference();
        LOGGER.info("measureReference finished");
    }

    @RequestMapping(value = "/measureReferences", method = RequestMethod.GET)
    public List<MeasureReference> measureReferences() {
        LOGGER.info("measureReferences");
        return measureReferenceRepository.findAll();
    }

    @Autowired
    public void setCommandRunner(CommandRunner commandRunner) {
        this.commandRunner = commandRunner;
    }

    @Autowired
    public void setMeasureReferenceRepository(MeasureReferenceRepository measureReferenceRepository) {
        this.measureReferenceRepository = measureReferenceRepository;
    }
}
