package deltaanalytics.bruker.data.repository;

import deltaanalytics.bruker.Application;
import deltaanalytics.bruker.data.entity.MeasureSampleResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class MeasureSampleResultRepositoryTest {

    @Autowired
    MeasureSampleResultRepository measureSampleResultRepository;

    @Test
    public void create() {
        MeasureSampleResult measureSampleResult = new MeasureSampleResult();
        measureSampleResult.setFirstValue(1.0);
        measureSampleResult.setSecondValue(2.0);

        measureSampleResultRepository.save(measureSampleResult);

        MeasureSampleResult measureSampleResultFromDb = measureSampleResultRepository.findOne(measureSampleResult.getId());

        assertThat(measureSampleResult, is(equalTo(measureSampleResultFromDb)));
    }

    @Test
    public void update() {
        MeasureSampleResult measureSampleResult = new MeasureSampleResult();
        measureSampleResult.setFirstValue(1.0);
        measureSampleResult.setSecondValue(2.0);

        measureSampleResultRepository.save(measureSampleResult);

        double updatedFirstValue = 99.01;
        measureSampleResult.setFirstValue(updatedFirstValue);
        measureSampleResultRepository.save(measureSampleResult);

        MeasureSampleResult measureSampleResultUpdated = measureSampleResultRepository.findOne(measureSampleResult.getId());

        assertThat(measureSampleResultUpdated.getFirstValue(), is(equalTo(updatedFirstValue)));
    }

    @Test
    public void findAll() {
        MeasureSampleResult measureSampleResult = new MeasureSampleResult();
        measureSampleResult.setFirstValue(1.0);
        measureSampleResult.setSecondValue(2.0);

        measureSampleResultRepository.save(measureSampleResult);

        MeasureSampleResult measureSampleResult2 = new MeasureSampleResult();
        measureSampleResult2.setFirstValue(11.0);
        measureSampleResult2.setSecondValue(22.0);

        measureSampleResultRepository.save(measureSampleResult2);

        List<MeasureSampleResult> all = measureSampleResultRepository.findAll();

        assertThat(all.size(), is(equalTo(4)));
    }
}
