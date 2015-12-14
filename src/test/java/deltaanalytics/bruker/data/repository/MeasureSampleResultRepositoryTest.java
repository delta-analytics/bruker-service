package deltaanalytics.bruker.data.repository;

import deltaanalytics.bruker.data.entity.MeasureSampleResult;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MeasureSampleResultRepositoryTest {

    @After
    public void tearDown(){
        CleanTestMemDB.cleanUp();
    }

    @Test
    public void create(){
        MeasureSampleResult measureSampleResult = new MeasureSampleResult();
        measureSampleResult.setFirstValue(1.0);
        measureSampleResult.setSecondValue(2.0);

        MeasureSampleResultRepository measureSampleResultRepository = new MeasureSampleResultRepository();
        measureSampleResultRepository.createOrUpdate(measureSampleResult);

        MeasureSampleResult measureSampleResultFromDb = measureSampleResultRepository.read(measureSampleResult.getId());

        assertThat(measureSampleResult, is(equalTo(measureSampleResultFromDb)));
    }

    @Test
    public void update(){
        MeasureSampleResult measureSampleResult = new MeasureSampleResult();
        measureSampleResult.setFirstValue(1.0);
        measureSampleResult.setSecondValue(2.0);

        MeasureSampleResultRepository measureSampleResultRepository = new MeasureSampleResultRepository();
        measureSampleResultRepository.createOrUpdate(measureSampleResult);

        double updatedFirstValue = 99.01;
        measureSampleResult.setFirstValue(updatedFirstValue);
        measureSampleResultRepository.createOrUpdate(measureSampleResult);

        MeasureSampleResult measureSampleResultUpdated = measureSampleResultRepository.read(measureSampleResult.getId());

        assertThat(measureSampleResultUpdated.getFirstValue(), is(equalTo(updatedFirstValue)));
    }

    @Test
    public void findAll(){
        MeasureSampleResult measureSampleResult = new MeasureSampleResult();
        measureSampleResult.setFirstValue(1.0);
        measureSampleResult.setSecondValue(2.0);

        MeasureSampleResultRepository measureSampleResultRepository = new MeasureSampleResultRepository();
        measureSampleResultRepository.createOrUpdate(measureSampleResult);

        MeasureSampleResult measureSampleResult2 = new MeasureSampleResult();
        measureSampleResult2.setFirstValue(11.0);
        measureSampleResult2.setSecondValue(22.0);

        measureSampleResultRepository.createOrUpdate(measureSampleResult2);

        List<MeasureSampleResult> all = measureSampleResultRepository.findAll();

        assertThat(all.size(), is(equalTo(2)));
    }
}
