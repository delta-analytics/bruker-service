package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.hardware.CommandRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetVersionController {
    @Autowired
    private CommandRunner commandRunner;

    @RequestMapping("/version")
    public String getVersion() {
        String result = "";
        try {
            result = commandRunner.getVersion();
        } catch (Exception e) {
            e.printStackTrace();
            result = "Error " + e.getMessage();
        }
        return result;
    }
}
