package deltaanalytics.bruker.data.repository;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import org.springframework.beans.factory.annotation.Autowired;

public class BrukerParametersRepositoryImpl implements BrukerParametersRepositoryCustom {
    private BrukerParametersRepository brukerParametersRepository;


    @Override
    public void saveAndMarkNewDefaults(BrukerParameters newDefaultBrukerParameters) {
        BrukerParameters actualDefaults = brukerParametersRepository.findByCurrentDefaultTrue();
        if (actualDefaults != null) {
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
