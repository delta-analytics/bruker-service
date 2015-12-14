package deltaanalytics.bruker.hardware.commands;

import deltaanalytics.bruker.hardware.dto.BrukerParametersForTestFactory;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MeasureReferenceCommandTest {
    @Test
    public void run() throws Exception {
        String host = "localhost";
        int port = 80;
        MeasureReferenceCommand measureReferenceCommand = new MeasureReferenceCommand();
        String brukerCommand = measureReferenceCommand.build(host, port, BrukerParametersForTestFactory.getBrukerParameters());

        assertThat(brukerCommand, is(equalTo(expectedRequest())));

    }

    private String expectedRequest() throws Exception {
        return ExpectedCommandListForTestFactory.build("http://localhost:80/OpusCommand.htm?MeasureReference (0, " + BrukerParametersForTestFactory.asString() + ")");
    }
}
