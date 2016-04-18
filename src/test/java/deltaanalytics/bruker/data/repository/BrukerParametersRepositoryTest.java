package deltaanalytics.bruker.data.repository;

import deltaanalytics.bruker.Application;
import deltaanalytics.bruker.data.entity.BrukerParameters;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@Transactional
public class BrukerParametersRepositoryTest {
    @Autowired
    BrukerParametersRepository brukerParametersRepository;

    @Test
    public void create() {
        BrukerParameters noDefault = BrukerParameters.getDefault();
        brukerParametersRepository.saveAndMarkNewDefaults(noDefault);
        BrukerParameters theDefault = BrukerParameters.getDefault();
        brukerParametersRepository.saveAndMarkNewDefaults(theDefault);

        BrukerParameters brukerParameters = brukerParametersRepository.findByCurrentDefaultTrue();

        assertThat(brukerParameters, is(equalTo(theDefault)));
    }

    @Test
    public void makeCurrentDefault() {
        BrukerParameters defaultParam = BrukerParameters.getDefault();
        brukerParametersRepository.saveAndMarkNewDefaults(defaultParam);

        BrukerParameters brukerParameters = brukerParametersRepository.findByCurrentDefaultTrue();

        assertThat(brukerParameters, is(equalTo(defaultParam)));

        BrukerParameters newDefaultParam = BrukerParameters.getDefault();
        newDefaultParam.setDAP("NEW!");

        brukerParametersRepository.saveAndMarkNewDefaults(newDefaultParam);

        BrukerParameters newDefaultInDb = brukerParametersRepository.findByCurrentDefaultTrue();

        assertThat(newDefaultInDb, is(equalTo(newDefaultParam)));
    }
}
