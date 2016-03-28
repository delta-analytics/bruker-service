package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.hardware.CommandRunner;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MeasureSampleControllerTest {
    @Test
    public void measureSample(){
        MeasureSampleController measureSampleController = new MeasureSampleController();
        CommandRunner commandRunner = mock(CommandRunner.class);
        measureSampleController.setCommandRunner(commandRunner);

        measureSampleController.measureSample();

        verify(commandRunner).measureSample();
    }
}
