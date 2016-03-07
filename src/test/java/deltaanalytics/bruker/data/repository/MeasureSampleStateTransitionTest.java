package deltaanalytics.bruker.data.repository;

import deltaanalytics.bruker.Application;
import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.entity.BrukerStateEnum;
import deltaanalytics.bruker.data.entity.MeasureSample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class MeasureSampleStateTransitionTest {

    @Autowired
    MeasureSampleRepository measureSampleRepository;

    @Test
    public void stateTransition(){
        MeasureSample measureSample = new MeasureSample();
        measureSample.setBrukerParameters(BrukerParameters.getDefault());
        measureSample.setBrukerStateEnum(BrukerStateEnum.QUEUED);

        measureSampleRepository.save(measureSample);

        MeasureSample measureSampleInDb = measureSampleRepository.findOne(measureSample.getId());

        assertThat(measureSampleInDb.getBrukerStateEnum(), is(equalTo(BrukerStateEnum.QUEUED)));

        measureSampleInDb.setBrukerStateEnum(BrukerStateEnum.FINISHED);
        measureSampleRepository.save(measureSampleInDb);

        MeasureSample measureSampleInDbWithNewBrukerState = measureSampleRepository.findOne(measureSampleInDb.getId());

        assertThat(measureSampleInDbWithNewBrukerState.getBrukerStateEnum(), is(equalTo(BrukerStateEnum.FINISHED)));
    }
}
