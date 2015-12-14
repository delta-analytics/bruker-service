package deltaanalytics.bruker.hardware.commands;

import java.net.URI;
import java.net.URL;

class ExpectedCommandListForTestFactory {
    static String build(String brukerCommand) throws Exception {
        URL url = new URL(brukerCommand);
        URI uri = new URI(url.getProtocol(),
                url.getUserInfo(),
                url.getHost(),
                url.getPort(),
                url.getPath(),
                url.getQuery(),
                url.getRef());
        url = uri.toURL();  // correct encoded URL
        return url.getFile();
    }
}
