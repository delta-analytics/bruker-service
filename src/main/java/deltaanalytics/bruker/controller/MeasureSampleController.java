package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.hardware.CommandRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeasureSampleController {
    private Logger LOGGER = LoggerFactory.getLogger(MeasureReferenceController.class);
    private CommandRunner commandRunner;

    @RequestMapping(value = "/measureSample", method = RequestMethod.POST)
    public void measureSample() {
        LOGGER.info("measureSample");
        commandRunner.measureSample();
        LOGGER.info("measureSample finished");
    }

    @Autowired
    public void setCommandRunner(CommandRunner commandRunner) {
        this.commandRunner = commandRunner;
    }

}
