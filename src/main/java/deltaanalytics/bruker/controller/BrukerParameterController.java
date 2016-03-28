package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.repository.BrukerParametersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BrukerParameterController {
    private Logger LOGGER = LoggerFactory.getLogger(BrukerParameterController.class);
    private BrukerParametersRepository brukerParametersRepository;

    @RequestMapping(value = "/defaultParameter", method = RequestMethod.POST)
    public void defaults(@RequestBody BrukerParameters brukerParameters) {
        LOGGER.info("POST defaults " + brukerParameters.toString());
        brukerParametersRepository.saveAndMarkNewDefaults(brukerParameters);
    }

    @RequestMapping(value = "/defaultParameter", method = RequestMethod.GET)
    public BrukerParameters getDefaults() {
        LOGGER.info("GET defaults");
        return brukerParametersRepository.findByCurrentDefaultTrue();
    }

    @Autowired
    public void setBrukerParametersRepository(BrukerParametersRepository brukerParametersRepository) {
        this.brukerParametersRepository = brukerParametersRepository;
    }
}
