package deltaanalytics.bruker.hardware.dto;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BrukerDefaultParametersTest {
    @Test
    public void checkCorrectDefaultValues(){
        assertThat(BrukerParameters.getDefault(), is(equalTo(defaults())));
    }

    private BrukerParameters defaults() {
        BrukerParameters brukerDefaultParameters = new BrukerParameters();
        brukerDefaultParameters.setADP("1");
        brukerDefaultParameters.setADT(0);
        brukerDefaultParameters.setAPF("B3");
        brukerDefaultParameters.setAPT("Open");
        brukerDefaultParameters.setAQM("DD");
        brukerDefaultParameters.setBMS("CaF2");
        brukerDefaultParameters.setBSF("C:\\OPUS_7.0.129\\");
        brukerDefaultParameters.setCHN("Module port");
        brukerDefaultParameters.setCNM("Administrator");
        brukerDefaultParameters.setCOF(64);
        brukerDefaultParameters.setDAP("C:\\OPUS_7.0.129\\MEAS3");
        brukerDefaultParameters.setDEL(0);
        brukerDefaultParameters.setDIG(0);
        brukerDefaultParameters.setDLY(0);
        brukerDefaultParameters.setDMX("1");
        brukerDefaultParameters.setDPA(6);
        brukerDefaultParameters.setDPO(6);
        brukerDefaultParameters.setDTC("TE-MCT-PV [Internal]");
        brukerDefaultParameters.setEXP("frank.xpm");
        brukerDefaultParameters.setGSG("ON");
        brukerDefaultParameters.setHFQ(1800);
        brukerDefaultParameters.setHFW(8000);
        brukerDefaultParameters.setIRS(700);
        brukerDefaultParameters.setHPF(1);
        brukerDefaultParameters.setLFQ(4000);
        brukerDefaultParameters.setLFW(1800);
        brukerDefaultParameters.setLPF("-1");
        brukerDefaultParameters.setMIN(1.0);
        brukerDefaultParameters.setMIR(1.0);
        brukerDefaultParameters.setNAM("<snm>");
        brukerDefaultParameters.setNLI(1);
        brukerDefaultParameters.setNSS(32);
        brukerDefaultParameters.setNSR(32);
        brukerDefaultParameters.setOEX("0");
        brukerDefaultParameters.setOPF("Open");
        brukerDefaultParameters.setPGN("1");
        brukerDefaultParameters.setPGR("1");
        brukerDefaultParameters.setPHR(32);
        brukerDefaultParameters.setPHZ("PW");
        brukerDefaultParameters.setPLF("AB");
        brukerDefaultParameters.setPTH("C:\\OPUS_7.0.129\\MEAS3");
        brukerDefaultParameters.setRCH("Module port");
        brukerDefaultParameters.setRES(1.0);
        brukerDefaultParameters.setRGN("-1");
        brukerDefaultParameters.setSAN("Test24.1.dpt");
        brukerDefaultParameters.setSEP(",");
        brukerDefaultParameters.setSFM("MATRIX-MF");
        brukerDefaultParameters.setSGN("-1");
        brukerDefaultParameters.setSNM("Test24");
        brukerDefaultParameters.setSON("Off");
        brukerDefaultParameters.setVEL("40.0");
        brukerDefaultParameters.setX64("0");
        brukerDefaultParameters.setXPP("C:\\OPUS_7.0.129\\XPM");
        brukerDefaultParameters.setYON("0");
        brukerDefaultParameters.setZFF("4");
        return brukerDefaultParameters;
    }
}