package deltaanalytics.bruker.hardware.commands;

import deltaanalytics.bruker.hardware.dto.BrukerParametersForTestFactory;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Ignore
public class SaveAsCommandTest {
    @Test
    public void run() throws Exception {
        String host = "localhost";
        int fileId = 433;
        SaveAsCommand saveAsCommand = new SaveAsCommand();

        String brukerCommand = saveAsCommand.build(host, BrukerParametersForTestFactory.getBrukerParameters(), fileId);

        assertThat(brukerCommand, is(equalTo(expectedRequest(fileId))));
    }

    private String expectedRequest(int fileId) throws Exception {
        return ExpectedCommandListForTestFactory.build("http://localhost/SaveAs ([" + fileId + ":AB], " + BrukerParametersForTestFactory.asString() + ")");
    }
}
