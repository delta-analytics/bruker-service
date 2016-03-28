package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.hardware.CommandRunner;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MeasureReferenceControllerTest {

    @Test
    public void measureReference(){
        MeasureReferenceController measureReferenceController = new MeasureReferenceController();
        CommandRunner commandRunner = mock(CommandRunner.class);
        measureReferenceController.setCommandRunner(commandRunner);

        measureReferenceController.measureReference();

        verify(commandRunner).measureReference();
    }
}
