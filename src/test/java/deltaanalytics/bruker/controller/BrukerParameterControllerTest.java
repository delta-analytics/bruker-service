package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.Application;
import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.repository.BrukerParametersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class BrukerParameterControllerTest {
    @Autowired
    BrukerParametersRepository brukerParametersRepository;

    @Test
    public void postDefaultParameter() {
        BrukerParameters brukerParameters = BrukerParameters.getDefault();
        String nam = "NAM" + System.currentTimeMillis();
        brukerParameters.setNAM(nam);
        new TestRestTemplate().postForLocation("http://localhost:50000/defaultParameter", brukerParameters);

        assertThat(brukerParametersRepository.findByCurrentDefaultTrue(), is(equalTo(brukerParameters)));
    }
}
