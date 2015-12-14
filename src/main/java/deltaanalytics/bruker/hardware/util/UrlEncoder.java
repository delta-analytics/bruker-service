package deltaanalytics.bruker.hardware.util;

import java.net.URI;
import java.net.URL;

public class UrlEncoder {
    public static URL encode(String stringToEncode) throws Exception {
        URL url = new URL(stringToEncode);
        URI uri = new URI(url.getProtocol(),
                url.getUserInfo(),
                url.getHost(),
                url.getPort(),
                url.getPath(),
                url.getQuery(),
                url.getRef());
        return uri.toURL();
    }
}
