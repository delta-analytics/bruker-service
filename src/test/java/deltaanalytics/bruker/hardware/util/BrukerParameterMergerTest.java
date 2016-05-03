package deltaanalytics.bruker.hardware.util;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.hardware.dto.MutableBrukerParametersDto;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Ignore
public class BrukerParameterMergerTest {

    @Test
    public void merge() throws Exception {
        MutableBrukerParametersDto mutableBrukerParametersDto = build();
        BrukerParameters brukerParameters = BrukerParameters.getDefault();

        BrukerParameters mergedBrukerParameters = new BrukerParameterMerger().merge(mutableBrukerParametersDto, brukerParameters);
        assertThat(mergedBrukerParameters, is(equalTo(expected())));
    }

    private MutableBrukerParametersDto build() {
        MutableBrukerParametersDto mutableBrukerParametersDto = new MutableBrukerParametersDto();
        mutableBrukerParametersDto.setNSS(9999);
        mutableBrukerParametersDto.setId(1);
        mutableBrukerParametersDto.setSAN("mutSan");
        mutableBrukerParametersDto.setAPF("mutApf");
        mutableBrukerParametersDto.setAPT("mutApt");
        mutableBrukerParametersDto.setAQM("mutAqm");
        mutableBrukerParametersDto.setBMS("mutBms");
        mutableBrukerParametersDto.setBSF("mutBsf");
        mutableBrukerParametersDto.setCNM("mutCnm");
        mutableBrukerParametersDto.setDAP("mutDap");
        mutableBrukerParametersDto.setDPA(9999);
        mutableBrukerParametersDto.setOPF("mutOpf");
        mutableBrukerParametersDto.setPHR(9999);
        mutableBrukerParametersDto.setPHZ("mutPhz");
        mutableBrukerParametersDto.setPTH("mutPth");
        mutableBrukerParametersDto.setDPO(9999);
        mutableBrukerParametersDto.setEXP("mutExp");
        mutableBrukerParametersDto.setHFQ(9999);
        mutableBrukerParametersDto.setLFW(9999);
        mutableBrukerParametersDto.setLFQ(9999);
        mutableBrukerParametersDto.setNAM("mutNam");
        mutableBrukerParametersDto.setNSS(9999);
        mutableBrukerParametersDto.setNSR(9999);
        mutableBrukerParametersDto.setPLF("mutPlf");
        mutableBrukerParametersDto.setXPP("mutXpp");
        mutableBrukerParametersDto.setHFW(9999);
        return mutableBrukerParametersDto;
    }

    private BrukerParameters expected() {
        BrukerParameters brukerParameters = BrukerParameters.getDefault();
        brukerParameters.setNSS(9999);
        brukerParameters.setId(1);
        brukerParameters.setSAN("mutSan");
        brukerParameters.setAPF("mutApf");
        brukerParameters.setAPT("mutApt");
        brukerParameters.setAQM("mutAqm");
        brukerParameters.setBMS("mutBms");
        brukerParameters.setBSF("mutBsf");
        brukerParameters.setCNM("mutCnm");
        brukerParameters.setDAP("mutDap");
        brukerParameters.setDPA(9999);
        brukerParameters.setOPF("mutOpf");
        brukerParameters.setPHR(9999);
        brukerParameters.setPHZ("mutPhz");
        brukerParameters.setPTH("mutPth");
        brukerParameters.setDPO(9999);
        brukerParameters.setEXP("mutExp");
        brukerParameters.setHFQ(9999);
        brukerParameters.setLFW(9999);
        brukerParameters.setNAM("mutNam");
        brukerParameters.setNSS(9999);
        brukerParameters.setNSR(9999);
        brukerParameters.setPLF("mutPlf");
        brukerParameters.setXPP("mutXpp");
        brukerParameters.setHFW(9999);
        return brukerParameters;
    }
}