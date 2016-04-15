package deltaanalytics.bruker.controller.simulation;

import deltaanalytics.bruker.data.entity.BrukerStateEnum;
import deltaanalytics.bruker.data.entity.MeasureReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Profile("simulation")
@RestController
public class MeasureReferenceController {
    private Logger LOGGER = LoggerFactory.getLogger(MeasureReferenceController.class);
    private List<MeasureReference> measureReferences = new ArrayList<>();
    private BrukerParameterWrapper brukerParameterWrapper;

    @RequestMapping(value = "/measureReference", method = RequestMethod.POST)
    public void measureReference() {
        LOGGER.info("measureReference");
        MeasureReference measureReference = new MeasureReference();
        measureReference.setBrukerParameters(brukerParameterWrapper.getBrukerParameters());
        measureReference.setBrukerStateEnum(BrukerStateEnum.FINISHED);
        measureReference.setCreatedAt(LocalDateTime.now());
        measureReference.setFinishedAt(LocalDateTime.now());
        measureReference.setId(new Random().nextLong());
        measureReferences.add(measureReference);
        LOGGER.info("measureReference finished");
    }

    @RequestMapping(value = "/measureReferences", method = RequestMethod.GET)
    public List<MeasureReference> measureReferences() {
        LOGGER.info("measureReferences");
        return measureReferences;
    }

    public void setBrukerParameterWrapper(BrukerParameterWrapper brukerParameterWrapper) {
        this.brukerParameterWrapper = brukerParameterWrapper;
    }
}
