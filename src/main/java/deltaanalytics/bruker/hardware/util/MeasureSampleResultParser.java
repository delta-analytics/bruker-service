package deltaanalytics.bruker.hardware.util;


import deltaanalytics.bruker.data.entity.MeasureSampleResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MeasureSampleResultParser {
    public List<MeasureSampleResult> parse(String path, String filename) throws IOException {
        Path pathWithFile = Paths.get(path, filename);
        List<MeasureSampleResult> measureSampleResults = new ArrayList<>();
        Files.lines(pathWithFile).forEach(s -> measureSampleResults.add(new MeasureSampleResult(s)));
        return measureSampleResults;
    }
}
