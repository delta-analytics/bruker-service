package deltaanalytics.bruker.data.repository;

import deltaanalytics.bruker.Application;
import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.entity.MeasureSample;
import deltaanalytics.bruker.data.entity.MoleculeResult;
import deltaanalytics.bruker.data.entity.MoleculeResults;
import java.util.List;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@Transactional
public class MeasureSampleRepositoryTest {

    @Autowired
    MeasureSampleRepository measureSampleRepository;

    @Test
    public void create() {
        MeasureSample measureSample = new MeasureSample();
        MoleculeResult moleculeResult1 = new MoleculeResult();
        MoleculeResult moleculeResult2 = new MoleculeResult();
        moleculeResult1.setMixingRatioFromHitranSum(2.001);
        moleculeResult2.setMixingRatioFromHitranSum(1.993);
        MoleculeResults moleculeResults = new MoleculeResults();
        moleculeResults.addMoleculeResult(moleculeResult1);
        moleculeResults.addMoleculeResult(moleculeResult2);
        measureSample.setMoleculeResults(moleculeResults);
        measureSample.setBrukerParameters(BrukerParameters.getDefault());

        measureSampleRepository.save(measureSample);

        MeasureSample measureSampleInDb = measureSampleRepository.findOne(measureSample.getId());

        assertThat(measureSample, is(equalTo(measureSampleInDb)));
        final List<MoleculeResult> moleculeResultListFromDB = measureSample.getMoleculeResults().getMoleculeResultList();
        assertThat(moleculeResultListFromDB.size(), is(2));
        assertThat(moleculeResultListFromDB.get(0), is(moleculeResult1));
        assertThat(moleculeResultListFromDB.get(1), is(moleculeResult2));
        assertThat(measureSample.getBrukerParameters(), is(not(nullValue())));
        assertThat(measureSample.getBrukerParameters(), is(equalTo(BrukerParameters.getDefault())));
        assertThat(measureSample.getCreatedAt(), is(not(nullValue())));
    }
}
