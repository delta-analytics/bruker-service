package deltaanalytics.bruker.data.repository;

import deltaanalytics.bruker.Application;
import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.entity.MeasureReference;
import javax.transaction.Transactional;
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
public class MeasureReferenceRepositoryTest {

    @Autowired
    MeasureReferenceRepository measureReferenceRepository;

    @Test
    public void create() {
        MeasureReference measureReference = new MeasureReference();
        measureReference.setBrukerParameters(BrukerParameters.getDefault());

        measureReferenceRepository.save(measureReference);

        MeasureReference measureReferenceInDb = measureReferenceRepository.findOne(measureReference.getId());

        assertThat(measureReference, is(equalTo(measureReferenceInDb)));
        assertThat(measureReference.getBrukerParameters(), is(not(nullValue())));
        assertThat(measureReference.getBrukerParameters(), is(equalTo(BrukerParameters.getDefault())));
    }
}
