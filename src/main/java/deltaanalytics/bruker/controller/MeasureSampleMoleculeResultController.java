package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.data.entity.MeasureSample;
import deltaanalytics.bruker.data.entity.MoleculeResult;
import deltaanalytics.bruker.data.repository.MeasureSampleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@Profile({"production", "test"})
@RestController
public class MeasureSampleMoleculeResultController {
    private Logger LOGGER = LoggerFactory.getLogger(MeasureSampleMoleculeResultController.class);
    @Autowired
    private MeasureSampleRepository measureSampleRepository;

    @RequestMapping(value = "/moleculeResult/{measureSampleId}", method = RequestMethod.POST)
    public void addMoleculeResult(@PathVariable Long measureSampleId, @RequestBody MoleculeResult measureSampleMoleculeResult) {
        LOGGER.info("POST moleculeResult " + measureSampleMoleculeResult.toString() + " for " + measureSampleId);
        MeasureSample measureSample = measureSampleRepository.findOne(measureSampleId);
        measureSample.setMeasureSampleMoleculeResult(measureSampleMoleculeResult);
        measureSampleRepository.save(measureSample);
    }
}
