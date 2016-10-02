package deltaanalytics.bruker.controller;

import deltaanalytics.bruker.data.entity.MeasureSample;
import deltaanalytics.bruker.data.entity.MoleculeResults;
import deltaanalytics.bruker.data.repository.MeasureSampleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@Profile({"production", "test"})
@RestController
public class MeasureSampleMoleculeResultsController {
    private Logger LOGGER = LoggerFactory.getLogger(MeasureSampleMoleculeResultsController.class);
    @Autowired
    private MeasureSampleRepository measureSampleRepository;

    @RequestMapping(value = "/moleculeResults/{measureSampleId}", method = RequestMethod.POST)
    public void addMoleculeResults(@PathVariable Long measureSampleId, @RequestBody MoleculeResults measuredMoleculeResults) {
        LOGGER.info("POST moleculeResults " + measuredMoleculeResults + " for " + measureSampleId);
        MeasureSample measureSample = measureSampleRepository.findOne(measureSampleId);
        measureSample.setMoleculeResults(measuredMoleculeResults);
        measureSampleRepository.save(measureSample);
    }
}
