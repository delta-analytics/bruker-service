package deltaanalytics.bruker.hardware.commands;

import deltaanalytics.bruker.hardware.util.UrlEncoder;

public class UnloadCommand {

    public String build(String host, int fileId) throws Exception {
        return UrlEncoder.encode("http://" + host + "/OpusCommand.htm?Unload ([" + fileId + "], {})").getFile();
    }
}
