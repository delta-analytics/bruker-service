package deltaanalytics.bruker.data.repository;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BrukerParametersRepositoryImpl implements BrukerParametersRepositoryCustom {
    private Logger LOGGER = LoggerFactory.getLogger(BrukerParametersRepositoryImpl.class);
    private BrukerParametersRepository brukerParametersRepository;

    @Override
    public void saveAndMarkNewDefaults(BrukerParameters newDefaultBrukerParameters) {
        LOGGER.info("saveAndMarkNewDefaults " + newDefaultBrukerParameters);
        BrukerParameters actualDefaults = brukerParametersRepository.findByCurrentDefaultTrue();
        if (actualDefaults != null) {
            LOGGER.info("actualDefaults before " + actualDefaults);
            actualDefaults.setCurrentDefault(false);
            brukerParametersRepository.save(actualDefaults);
        }
        newDefaultBrukerParameters.setCurrentDefault(true);
        brukerParametersRepository.save(newDefaultBrukerParameters);
    }


    @Autowired
    public void setBrukerParametersRepository(BrukerParametersRepository brukerParametersRepository) {
        this.brukerParametersRepository = brukerParametersRepository;
    }
}
