package deltaanalytics.bruker.hardware.util;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.hardware.dto.MutableBrukerParametersDto;
import org.springframework.stereotype.Component;

@Component
public class BrukerParameterMerger {
    public BrukerParameters merge(MutableBrukerParametersDto mutableBrukerParametersDto, BrukerParameters brukerParameters) {
        brukerParameters.setNSS(mutableBrukerParametersDto.getNSS());
        brukerParameters.setSAN(mutableBrukerParametersDto.getSAN());
        brukerParameters.setAPF(mutableBrukerParametersDto.getAPF());
        brukerParameters.setAPT(mutableBrukerParametersDto.getAPT());
        brukerParameters.setAQM(mutableBrukerParametersDto.getAQM());
        brukerParameters.setBMS(mutableBrukerParametersDto.getBMS());
        if (mutableBrukerParametersDto.getBSF() != null) {
            brukerParameters.setBSF(mutableBrukerParametersDto.getBSF());
        }
        brukerParameters.setCNM(mutableBrukerParametersDto.getCNM());
        brukerParameters.setDAP(mutableBrukerParametersDto.getDAP());
        brukerParameters.setDPA(mutableBrukerParametersDto.getDPA());
        brukerParameters.setOPF(mutableBrukerParametersDto.getOPF());
        brukerParameters.setPHR(mutableBrukerParametersDto.getPHR());
        brukerParameters.setPHZ(mutableBrukerParametersDto.getPHZ());
        brukerParameters.setPTH(mutableBrukerParametersDto.getPTH());
        brukerParameters.setDPO(mutableBrukerParametersDto.getDPO());
        brukerParameters.setEXP(mutableBrukerParametersDto.getEXP());
        brukerParameters.setHFQ(mutableBrukerParametersDto.getHFQ());
        brukerParameters.setHFW(mutableBrukerParametersDto.getHFW());
        brukerParameters.setLFW(mutableBrukerParametersDto.getLFW());
        brukerParameters.setNAM(mutableBrukerParametersDto.getNAM());
        brukerParameters.setNSS(mutableBrukerParametersDto.getNSS());
        brukerParameters.setNSR(mutableBrukerParametersDto.getNSR());
        brukerParameters.setPLF(mutableBrukerParametersDto.getPLF());
        brukerParameters.setXPP(mutableBrukerParametersDto.getXPP());
        return brukerParameters;
    }
}
