package deltaanalytics.bruker.hardware.dto;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BrukerParametersToHttpParamBuilderTest {
    @Test
    public void build() {
        BrukerParametersToHttpParamBuilder brukerParametersToHttpParamBuilder = new BrukerParametersToHttpParamBuilder();

        BrukerParameters brukerParameters = BrukerParametersForTestFactory.getBrukerParameters();
        assertThat(brukerParametersToHttpParamBuilder.build(brukerParameters), is(equalTo(BrukerParametersForTestFactory.asString())));
    }

}
