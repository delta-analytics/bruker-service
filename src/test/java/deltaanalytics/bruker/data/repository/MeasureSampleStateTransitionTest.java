package deltaanalytics.bruker.data.repository;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.entity.BrukerStateEnum;
import deltaanalytics.bruker.data.entity.MeasureSample;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MeasureSampleStateTransitionTest {
    @Test
    public void stateTransition(){
        MeasureSample measureSample = new MeasureSample();
        measureSample.setBrukerParameters(BrukerParameters.getDefault());
        measureSample.setBrukerStateEnum(BrukerStateEnum.QUEUED);

        MeasureSampleRepository measureSampleRepository = new MeasureSampleRepository();
        measureSampleRepository.createOrUpdate(measureSample);

        MeasureSample measureSampleInDb = measureSampleRepository.read(measureSample.getId());

        assertThat(measureSampleInDb.getBrukerStateEnum(), is(equalTo(BrukerStateEnum.QUEUED)));

        measureSampleInDb.setBrukerStateEnum(BrukerStateEnum.FINISHED);
        measureSampleRepository.createOrUpdate(measureSampleInDb);

        MeasureSample measureSampleInDbWithNewBrukerState = measureSampleRepository.read(measureSampleInDb.getId());

        assertThat(measureSampleInDbWithNewBrukerState.getBrukerStateEnum(), is(equalTo(BrukerStateEnum.FINISHED)));
    }
}
