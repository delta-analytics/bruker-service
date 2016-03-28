package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.hardware.CommandRunner;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetVersionControllerTest {
    @Test
    public void getVersion() throws Exception {
        GetVersionController getVersionController = new GetVersionController();
        CommandRunner commandRunner = mock(CommandRunner.class);
        getVersionController.setCommandRunner(commandRunner);
        when(commandRunner.getVersion()).thenReturn("1.0");

        String version = getVersionController.getVersion();

        assertThat(version, is("1.0"));
    }
}
