package deltaanalytics.bruker.data.repository;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BrukerParametersRepositoryTest {

    @Before
    public void setup() {
        CleanTestMemDB.cleanUp();
    }

    @Test
    public void create() {

        BrukerParametersRepository brukerParametersRepository = new BrukerParametersRepository();
        BrukerParameters noDefault = BrukerParameters.getDefault();
        noDefault.setCurrentDefault(false);
        brukerParametersRepository.createOrUpdate(noDefault);
        BrukerParameters theDefault = BrukerParameters.getDefault();
        brukerParametersRepository.createOrUpdate(theDefault);

        BrukerParameters brukerParameters = brukerParametersRepository.readCurrentActiveDefault();

        assertThat(brukerParameters, is(equalTo(theDefault)));
    }

    @Test
    public void makeCurrentDefault() {
        BrukerParametersRepository brukerParametersRepository = new BrukerParametersRepository();
        BrukerParameters defaultParam = BrukerParameters.getDefault();
        brukerParametersRepository.createOrUpdate(defaultParam);

        BrukerParameters brukerParameters = brukerParametersRepository.readCurrentActiveDefault();

        assertThat(brukerParameters, is(equalTo(defaultParam)));

        BrukerParameters newDefaultParam = BrukerParameters.getDefault();
        newDefaultParam.setDAP("NEW!");
        brukerParametersRepository.createOrUpdateAndMakeDefault(newDefaultParam);

        BrukerParameters newDefaultInDb = brukerParametersRepository.readCurrentActiveDefault();

        assertThat(newDefaultInDb, is(equalTo(newDefaultParam)));
    }
}
