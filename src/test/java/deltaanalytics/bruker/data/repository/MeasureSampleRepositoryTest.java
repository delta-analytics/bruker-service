package deltaanalytics.bruker.data.repository;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.entity.MeasureSample;
import deltaanalytics.bruker.data.entity.MeasureSampleResult;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class MeasureSampleRepositoryTest {
    @Test
    public void create(){
        MeasureSample measureSample = new MeasureSample();
        MeasureSampleResult measureSampleResult = new MeasureSampleResult();
        measureSampleResult.setFirstValue(1.001);
        measureSampleResult.setSecondValue(2.002);
        measureSample.addMeasureSampleResult(measureSampleResult);
        measureSample.setBrukerParameters(BrukerParameters.getDefault());

        MeasureSampleRepository measureSampleRepository = new MeasureSampleRepository();
        measureSampleRepository.createOrUpdate(measureSample);

        MeasureSample measureSampleInDb = measureSampleRepository.read(measureSample.getId());

        assertThat(measureSample, is(equalTo(measureSampleInDb)));
        assertThat(measureSample.getMeasureSampleResults().size(), is(equalTo(1)));
        assertThat(measureSample.getMeasureSampleResults().get(0), is(equalTo(measureSampleResult)));
        assertThat(measureSample.getBrukerParameters(), is(not(nullValue())));
        assertThat(measureSample.getBrukerParameters(), is(equalTo(BrukerParameters.getDefault())));
        assertThat(measureSample.getCreatedAt(), is(not(nullValue())));
    }
}
