package deltaanalytics.bruker.hardware.commands;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MeasureSampleCommandResultTest {
    @Test
    public void extractPath(){
        String result = "OK  1 C:\\OPUS_7.0.129\\MEAS3\\Test25.0 1 744  0";
        String[] resultAsSplittedArray = result.split(" ");

        MeasureSampleCommandResult measureSampleCommandResult = new MeasureSampleCommandResult(resultAsSplittedArray);

        assertThat(measureSampleCommandResult.getPath(), is(equalTo("C:\\OPUS_7.0.129\\MEAS3")));
    }

    @Test
    public void extractFileName(){
        String result = "OK  1 \"C:\\OPUS_7.0.129\\MEAS3\\Test25.0\" 1 744  0";
        String[] resultAsSplittedArray = result.split(" ");

        MeasureSampleCommandResult measureSampleCommandResult = new MeasureSampleCommandResult(resultAsSplittedArray);

        assertThat(measureSampleCommandResult.getFileName(), is(equalTo("Test25.0")));
    }
}
