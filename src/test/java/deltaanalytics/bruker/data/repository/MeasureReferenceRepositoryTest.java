package deltaanalytics.bruker.data.repository;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.entity.MeasureReference;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class MeasureReferenceRepositoryTest {
    @Test
    public void create(){
        CleanTestMemDB.cleanUp();
        MeasureReference measureReference = new MeasureReference();
        measureReference.setBrukerParameters(BrukerParameters.getDefault());

        MeasureReferenceRepository measureReferenceRepository = new MeasureReferenceRepository();
        measureReferenceRepository.createOrUpdate(measureReference);

        MeasureReference measureReferenceInDb = measureReferenceRepository.read(measureReference.getId());

        assertThat(measureReference, is(equalTo(measureReferenceInDb)));
        assertThat(measureReference.getBrukerParameters(), is(not(nullValue())));
        assertThat(measureReference.getBrukerParameters(), is(equalTo(BrukerParameters.getDefault())));
    }
}
