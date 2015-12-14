package deltaanalytics.bruker.hardware.commands;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.hardware.dto.BrukerParametersToHttpParamBuilder;
import deltaanalytics.bruker.hardware.util.UrlEncoder;

public class SaveAsCommand {

    public String build(String host, BrukerParameters brukerParameters, int fileId) throws Exception {
        return UrlEncoder.encode("http://" + host + "/SaveAs ([" + fileId + "]:AB], " + BrukerParametersToHttpParamBuilder.build(brukerParameters) + ")").getFile();
    }
}
