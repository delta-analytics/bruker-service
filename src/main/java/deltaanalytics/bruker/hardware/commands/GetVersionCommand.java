package deltaanalytics.bruker.hardware.commands;

import deltaanalytics.bruker.hardware.util.UrlEncoder;

public class GetVersionCommand {

    public String build(String host, int port) throws Exception {
        return UrlEncoder.encode("http://" + host + ":" + port + "/OpusCommand.htm?GET_VERSION").getFile();
    }
}
