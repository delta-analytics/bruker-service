package deltaanalytics.bruker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MathRestClient {
    private static final Logger logger = LoggerFactory.getLogger(MathRestClient.class);

    private RestTemplate restTemplate = new RestTemplate();
    @Value("${math-service.host}")
    private String host;
    @Value("${math-service.port}")
    private int port;
    @Value("${math-service.start.url}")
    private String mathServiceStartUrl;
    
    public void start(Long id) {
        logger.info("startCalculation " + id);
        String request = hostWithPort() + "/" + mathServiceStartUrl + "/" + id;
        logger.info(request);
         restTemplate.postForLocation(request, null);
    }

    private String hostWithPort() {
        return host + ":" + port;
    }
}
