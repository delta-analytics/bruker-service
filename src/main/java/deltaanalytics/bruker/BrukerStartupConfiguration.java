package deltaanalytics.bruker;

import deltaanalytics.bruker.data.entity.*;
import deltaanalytics.bruker.data.repository.BrukerParametersRepository;
import deltaanalytics.bruker.data.repository.MeasureSampleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Configuration
public class BrukerStartupConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(BrukerStartupConfiguration.class);

    @Autowired
    BrukerParametersRepository brukerParametersRepository;


    @Autowired
    MeasureSampleRepository measureSampleRepository;

    @PostConstruct
    public void initDefaultParameter(){
        BrukerParameters brukerParameters = brukerParametersRepository.findByCurrentDefaultTrue();
        if(brukerParameters == null){
            brukerParameters = BrukerParameters.getDefault();
            brukerParametersRepository.saveAndMarkNewDefaults(brukerParameters);
        }
    }
    @PostConstruct
    public void initDefaultSampleResults(){
        LOGGER.info("started initDefaultSampleResults");
        MoleculeResult ch4 = new MoleculeResult();
        ch4.setMolecule(5);
        ch4.setId(1L);
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

        //List<MoleculeResult> allMolecules = new ArrayList<>();
        //allMolecules.add(ch4);
        MoleculeResults moleculeResults = new MoleculeResults();
        //moleculeResults.setMoleculeResultList(allMolecules);   // FJ do it if you have all molecules calculated
        moleculeResults.addMoleculeResult(ch4);

        MeasureSample measureSample = new MeasureSample();
        measureSample.setBrukerParameters(brukerParametersRepository.findByCurrentDefaultTrue());
        measureSample.setBrukerStateEnum(BrukerStateEnum.FINISHED);
        measureSample.setFilename("filename_ch4");
        measureSample.setCreatedAt(LocalDateTime.now());
        measureSample.setFinishedAt(LocalDateTime.now());
        measureSample.setId(1L);
        measureSample.setError("0");
        measureSample.setMoleculeResults(moleculeResults);
        LOGGER.info("MeasureSample=" + measureSample);
        measureSampleRepository.save(measureSample);
        LOGGER.info("finished initDefaultSampleResults");
    }
}
