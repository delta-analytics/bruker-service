package deltaanalytics.bruker.hardware.commands;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UnloadCommandTest {
    @Test
    public void run() throws Exception {
        UnloadCommand unloadCommand = new UnloadCommand();
        int fileId = 1;
        String host = "localhost";

        String brukerCommand = unloadCommand.build(host, fileId);

        assertThat(brukerCommand, is(equalTo(expectedRequest(fileId))));
    }

    private String expectedRequest(int fileId) throws Exception {
        return ExpectedCommandListForTestFactory.build("http://localhost/OpusCommand.htm?Unload ([" + fileId + "], {})");
    }
}