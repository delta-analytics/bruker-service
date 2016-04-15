package deltaanalytics.bruker.controller.simulation;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Profile("simulation")
@RestController
public class BrukerParameterController {
    private Logger LOGGER = LoggerFactory.getLogger(BrukerParameterController.class);
    private BrukerParameterWrapper brukerParameterWrapper;

    @RequestMapping(value = "/defaultParameter", method = RequestMethod.POST)
    public void defaults(@RequestBody BrukerParameters brukerParameters) {
        LOGGER.info("POST defaults " + brukerParameters.toString());
        brukerParameterWrapper.setBrukerParameters(brukerParameters);
    }

    @RequestMapping(value = "/defaultParameter", method = RequestMethod.GET)
    public BrukerParameters getDefaults() {
        LOGGER.info("GET defaults");
        return brukerParameterWrapper.getBrukerParameters();
    }

    @Autowired
    public void setBrukerParameterWrapper(BrukerParameterWrapper brukerParameterWrapper) {
        this.brukerParameterWrapper = brukerParameterWrapper;
    }
}
