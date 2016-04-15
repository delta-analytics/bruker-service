package deltaanalytics.bruker.controller.simulation;

import deltaanalytics.bruker.hardware.CommandRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("simulation")
@RestController
public class GetVersionController {
    private Logger LOGGER = LoggerFactory.getLogger(GetVersionController.class);

    @RequestMapping("/version")
    public String getVersion() {
        LOGGER.info("version");
        return "1.0";
    }
}
