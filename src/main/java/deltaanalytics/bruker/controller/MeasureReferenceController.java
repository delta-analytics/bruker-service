package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.hardware.CommandRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeasureReferenceController {
    private Logger LOGGER = LoggerFactory.getLogger(MeasureReferenceController.class);
    private CommandRunner commandRunner;

    @RequestMapping("/measureReference")
    public void measureReference() {
        LOGGER.info("measureReference");
        commandRunner.measureReference();
        LOGGER.info("measureReference finished");
    }

    @Autowired
    public void setCommandRunner(CommandRunner commandRunner) {
        this.commandRunner = commandRunner;
    }

}
