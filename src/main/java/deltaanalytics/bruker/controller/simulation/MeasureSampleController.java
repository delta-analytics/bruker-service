package deltaanalytics.bruker.controller.simulation;

import com.fasterxml.jackson.annotation.JsonView;
import deltaanalytics.bruker.data.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Profile("simulation")
@RestController
public class MeasureSampleController {
    private Logger LOGGER = LoggerFactory.getLogger(MeasureSampleController.class);
    private BrukerParameterWrapper brukerParameterWrapper;
    private List<MeasureSample> measuredSamples = new ArrayList<>();

    @RequestMapping(value = "/measureSample", method = RequestMethod.POST)
    public void measureSample() {
        LOGGER.info("measureSample");
        MoleculeResult ch4 = new MoleculeResult();
        ch4.setMolecule(5);
        ch4.setId(Math.abs(new Random().nextLong()));
        ch4.setMixingRatioFromHitranSum(2.04);
        ch4.setMixingRatioFromIntegralUnderTheCurve(1.98);
        ch4.setR2(0.97);
        ch4.setFovLineShift(1.0);
        ch4.setEffectiveResolution(2.2);
        ch4.setEstimatedFov(4.1);
        ch4.setOffsetFitConstant(0.0);
        ch4.setTimeInSecForLevenbergMarquardtFit(8.0);
        ch4.setAmplitudeFitFactor(1.1);
        ch4.setAdditionalLineShift(2.15);
        ch4.setAmplitudeFitFactor(3.1);
        MoleculeResults moleculeResults = new MoleculeResults();
        moleculeResults.addMoleculeResult(ch4);

        MeasureSample measureSample = new MeasureSample();
        measureSample.setFilename("filename" + Integer.valueOf(measuredSamples.size()));
        measureSample.setId(Math.abs(new Random().nextLong()));
        measureSample.setCreatedAt(LocalDateTime.now());
        measureSample.setFinishedAt(LocalDateTime.now());
        measureSample.setError("0");
        measureSample.setMoleculeResults(moleculeResults);
        measureSample.setBrukerStateEnum(BrukerStateEnum.FINISHED);
        measureSample.setBrukerParameters(brukerParameterWrapper.getBrukerParameters());
        measuredSamples.add(measureSample);
        LOGGER.info("measureSample finished");
    }

    @JsonView(View.SmallSummary.class)
    @RequestMapping(value = "/getMeasuredSamples", method = RequestMethod.GET)
    public List<MeasureSample> getMeasuredSamples() {
        LOGGER.info("measuredSamples in ArrayList " + measuredSamples.size());
        return measuredSamples;
    }

    @RequestMapping(value = "/getMeasuredSamples/{id}")
    public MeasureSample getMeasuredSample(@PathVariable long id) {
        LOGGER.info("measuredSample with " + id);
        MeasureSample result = null;
        for (MeasureSample measureSample : measuredSamples) {
            if (measureSample.getId() == id) {
                result = measureSample;
                break;
            }
        }
        return result;
    }

    @Autowired
    public void setBrukerParameterWrapper(BrukerParameterWrapper brukerParameterWrapper) {
        this.brukerParameterWrapper = brukerParameterWrapper;
    }
}
