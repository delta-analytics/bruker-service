package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.hardware.CommandRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetVersionController {
    private Logger LOGGER = LoggerFactory.getLogger(GetVersionController.class);
    @Autowired
    private CommandRunner commandRunner;

    @RequestMapping("/version")
    public String getVersion() {
        String result = "";
        try {
            result = commandRunner.getVersion();
        } catch (Exception e) {
            LOGGER.error("",e);
            result = "Error " + e.getMessage();
        }
        return result;
    }
}
