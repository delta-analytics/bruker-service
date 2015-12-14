package deltaanalytics.bruker.hardware.util;

import deltaanalytics.bruker.data.entity.MeasureSampleResult;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MeasureSampleResultParserTest {
    @Test
    public void parse() throws IOException {
        MeasureSampleResultParser measureSampleResultParser = new MeasureSampleResultParser();

        List<MeasureSampleResult> measureSampleResultList = measureSampleResultParser.parse("src/test/resources", "result.dpt");

        assertThat(measureSampleResultList.size(), is(equalTo(2)));
    }
}
