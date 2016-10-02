package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.repository.BrukerParametersRepository;
import deltaanalytics.bruker.hardware.dto.MutableBrukerParametersDto;
import deltaanalytics.bruker.hardware.util.BrukerParameterMerger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Profile({"production", "test"})
@RestController
public class BrukerParameterController {
    private Logger LOGGER = LoggerFactory.getLogger(BrukerParameterController.class);
    private BrukerParametersRepository brukerParametersRepository;
    private BrukerParameterMerger brukerParameterMerger;

    @RequestMapping(value = "/defaultParameter", method = RequestMethod.POST)
    public void defaults(@RequestBody MutableBrukerParametersDto mutableBrukerParametersDto) {
        LOGGER.info("POST defaults " + mutableBrukerParametersDto);
        brukerParametersRepository.saveAndMarkNewDefaults(brukerParameterMerger.merge(mutableBrukerParametersDto, brukerParametersRepository.findByCurrentDefaultTrue()));
    }

    @RequestMapping(value = "/defaultParameter", method = RequestMethod.GET)
    public BrukerParameters getDefaults() {
        LOGGER.info("GET defaults");
        BrukerParameters brukerParameters = brukerParametersRepository.findByCurrentDefaultTrue();
        if (brukerParameters == null) {
            brukerParameters = BrukerParameters.getDefault();
        }
        return brukerParameters;
    }

    @Autowired
    public void setBrukerParametersRepository(BrukerParametersRepository brukerParametersRepository) {
        this.brukerParametersRepository = brukerParametersRepository;
    }

    @Autowired
    public void setBrukerParameterMerger(BrukerParameterMerger brukerParameterMerger) {
        this.brukerParameterMerger = brukerParameterMerger;
    }
}
