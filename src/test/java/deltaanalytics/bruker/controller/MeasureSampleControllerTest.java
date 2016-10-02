package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.data.entity.MeasureSample;
import deltaanalytics.bruker.data.repository.MeasureSampleRepository;
import deltaanalytics.bruker.hardware.CommandRunner;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class MeasureSampleControllerTest {
    private MeasureSampleController measureSampleController;
    private CommandRunner commandRunner;
    private MeasureSampleRepository measureSampleRepository;

    @Before
    public void setup() {
        measureSampleController = new MeasureSampleController();
        commandRunner = mock(CommandRunner.class);
        measureSampleRepository = mock(MeasureSampleRepository.class);
        measureSampleController.setCommandRunner(commandRunner);
        measureSampleController.setMeasureSampleRepository(measureSampleRepository);
    }

    @Test
    public void measureSample() {
        measureSampleController.measureSample();
        verify(commandRunner).measureSample();
    }

    @Test
    public void measureSamples() {
        List<MeasureSample> measureSampleList = new ArrayList<>();
        measureSampleList.add(new MeasureSample());
        when(measureSampleRepository.findAll()).thenReturn(measureSampleList);

        List<MeasureSample> measureSamplesResult = measureSampleController.measuredSamples();

        assertThat(measureSamplesResult, is(equalTo(measureSampleList)));
    }

    @Test
    public void getMeasureSample(){
        MeasureSample measureSample = new MeasureSample();
        long id = 1;
        measureSample.setId(id);
        when(measureSampleRepository.findOne(id)).thenReturn(measureSample);

        MeasureSample result = measureSampleController.getMeasuredSample(id);

        assertThat(result, is(measureSample));
    }
}
