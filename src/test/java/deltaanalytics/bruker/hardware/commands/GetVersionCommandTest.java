package deltaanalytics.bruker.hardware.commands;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetVersionCommandTest {
    @Test
    public void getVersion() throws Exception {
        String host = "localhost";
        int port = 80;
        String brukerVersion = "1";
        GetVersionCommand getVersionCommand = new GetVersionCommand();
        String[] result = new String[1];
        result[0] = brukerVersion;

        assertThat(getVersionCommand.build(host, port), is(expectedRequest()));
    }

    private String expectedRequest() throws Exception {
        return ExpectedCommandListForTestFactory.build("http://localhost:80/OpusCommand.htm?GET_VERSION");
    }

}
