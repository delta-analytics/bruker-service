package deltaanalytics.bruker.hardware.commands;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.hardware.dto.BrukerParametersToHttpParamBuilder;
import deltaanalytics.bruker.hardware.util.UrlEncoder;

public class MeasureSampleCommand {

    public String build(String host, int port, BrukerParameters brukerParameters) throws Exception {
        return UrlEncoder.encode("http://" + host + ":" + port + "/OpusCommand.htm?MeasureSample (0, " + BrukerParametersToHttpParamBuilder.build(brukerParameters) + ")").getFile();
    }
}
