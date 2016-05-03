package deltaanalytics.bruker.data.repository;

import deltaanalytics.bruker.Application;
import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.entity.MeasureSample;
import deltaanalytics.bruker.data.entity.MeasureSampleResult;
import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@Transactional
@Ignore
public class MeasureSampleRepositoryTest {

    @Autowired
    MeasureSampleRepository measureSampleRepository;

    @Test
    public void create() {
        MeasureSample measureSample = new MeasureSample();
        MeasureSampleResult measureSampleResult = new MeasureSampleResult();
        measureSampleResult.setFirstValue(1.001);
        measureSampleResult.setSecondValue(2.002);
        measureSample.addMeasureSampleResult(measureSampleResult);
        measureSample.setBrukerParameters(BrukerParameters.getDefault());

        measureSampleRepository.save(measureSample);

        MeasureSample measureSampleInDb = measureSampleRepository.findOne(measureSample.getId());

        assertThat(measureSample, is(equalTo(measureSampleInDb)));
        assertThat(measureSample.getMeasureSampleResults().size(), is(equalTo(1)));
        assertThat(measureSample.getMeasureSampleResults().get(0), is(equalTo(measureSampleResult)));
        assertThat(measureSample.getBrukerParameters(), is(not(nullValue())));
        assertThat(measureSample.getBrukerParameters(), is(equalTo(BrukerParameters.getDefault())));
        assertThat(measureSample.getCreatedAt(), is(not(nullValue())));
    }
}
