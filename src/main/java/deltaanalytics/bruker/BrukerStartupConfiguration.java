package deltaanalytics.bruker;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.repository.BrukerParametersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class BrukerStartupConfiguration {
    @Autowired
    BrukerParametersRepository brukerParametersRepository;

    @PostConstruct
    public void initDefaultParameter(){
        BrukerParameters brukerParameters = brukerParametersRepository.findByCurrentDefaultTrue();
        if(brukerParameters == null){
            brukerParameters = BrukerParameters.getDefault();
            brukerParametersRepository.saveAndMarkNewDefaults(brukerParameters);
        }
    }
}
