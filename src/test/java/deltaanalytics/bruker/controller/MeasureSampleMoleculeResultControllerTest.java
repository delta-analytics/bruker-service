package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.data.entity.MeasureSample;
import deltaanalytics.bruker.data.entity.MoleculeResults;
import deltaanalytics.bruker.data.repository.MeasureSampleRepository;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

public class MeasureSampleMoleculeResultControllerTest {

    @Test
    public void addMoleculeResult() {
        MeasureSampleMoleculeResultsController measureSampleMoleculeResultController = new MeasureSampleMoleculeResultsController();
        MeasureSampleRepository measureSampleRepository = mock(MeasureSampleRepository.class);
        ReflectionTestUtils.setField(measureSampleMoleculeResultController, "measureSampleRepository", measureSampleRepository);
        long measureSampleId = 1l;
        MeasureSample measureSample = new MeasureSample();
        when(measureSampleRepository.findOne(measureSampleId)).thenReturn(measureSample);

        measureSampleMoleculeResultController.addMoleculeResults(measureSampleId, new MoleculeResults());

        verify(measureSampleRepository).findOne(measureSampleId);
        verify(measureSampleRepository).save(measureSample);
    }
}