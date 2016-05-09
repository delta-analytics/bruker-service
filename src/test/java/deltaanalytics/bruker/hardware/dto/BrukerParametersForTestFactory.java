package deltaanalytics.bruker.hardware.dto;


import deltaanalytics.bruker.data.entity.BrukerParameters;

public class BrukerParametersForTestFactory {
    private static BrukerParameters brukerParameters;

    public static BrukerParameters getBrukerParameters() {
        if (brukerParameters == null) {
            brukerParameters = new BrukerParameters();

            brukerParameters.setADP("1");
            brukerParameters.setADT(0);
            brukerParameters.setAPF("B3");
            brukerParameters.setAPT("Open");
            brukerParameters.setAQM("DD");
            brukerParameters.setBMS("CaF2");
            brukerParameters.setBSF("C:\\OPUS_7.0.129\\");
            brukerParameters.setCHN("Module port");
            brukerParameters.setCNM("Administrator");
            brukerParameters.setCOF(64);
            brukerParameters.setDAP("C:\\OPUS_7.0.129\\MEAS3");
            brukerParameters.setDEL(0);
            brukerParameters.setDIG(0);
            brukerParameters.setDLY(0);
            brukerParameters.setDMX("1");
            brukerParameters.setDPA(6);
            brukerParameters.setDPO(6);
            brukerParameters.setDTC("TE-MCT-PV [Internal]");
            brukerParameters.setEXP("frank.xpm");
            brukerParameters.setGSG("ON");
            brukerParameters.setHFQ(1800.0);
            brukerParameters.setHFW(8000.0);
            brukerParameters.setIRS(700);
            brukerParameters.setHPF(-1);
            brukerParameters.setLFQ(4000.0);
            brukerParameters.setLFW(1800.0);
            brukerParameters.setLPF("-1");
            brukerParameters.setMIN(1.0);
            brukerParameters.setMIR(1.0);
            brukerParameters.setNAM("<snm>");
            brukerParameters.setNLI(1);
            brukerParameters.setNSS(32);
            brukerParameters.setNSR(32);
            brukerParameters.setOEX("0");
            brukerParameters.setOPF("Open");
            brukerParameters.setPGN("1");
            brukerParameters.setPGR("1");
            brukerParameters.setPHR(32.0);
            brukerParameters.setPHZ("PW");
            brukerParameters.setPLF("AB");
            brukerParameters.setPTH("C:\\OPUS_7.0.129\\MEAS3\\");
            brukerParameters.setRCH("Module port");
            brukerParameters.setRES(1.0);
            brukerParameters.setRGN("-1");
            brukerParameters.setSAN("Test24.1.dpt");
            brukerParameters.setSEP(",");
            brukerParameters.setSFM("MATRIX-MF");
            brukerParameters.setSGN("-1");
            brukerParameters.setSNM("Test24");
            brukerParameters.setSON("Off");
            brukerParameters.setVEL("40.0");
            brukerParameters.setX64("0");
            brukerParameters.setXPP("C:\\OPUS_7.0.129\\XPM");
            brukerParameters.setYON("0");
            brukerParameters.setZFF("4");
        }
        return brukerParameters;
    }

    public static String asSaveAsString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("ADP='" + brukerParameters.getADP() + "', ");
        result.append("DAP='" + brukerParameters.getDAP() + "', ");
        result.append("OEX='" + brukerParameters.getOEX() + "', ");
        result.append("SAN='" + brukerParameters.getSAN() + ".dpt" + "', ");
        result.append("COF='" + brukerParameters.getCOF() + "', ");
        result.append("INP='" + brukerParameters.getINP() + "', ");
        result.append("IFP='" + brukerParameters.getIFP() + "', ");
        result.append("INM='" + brukerParameters.getINM() + "', ");
        result.append("IFN='" + brukerParameters.getIFN() + "', ");
        result.append("DPA=" + brukerParameters.getDPA() + ", ");
        result.append("DPO=" + brukerParameters.getDPO() + ", ");
        result.append("SEP='" + brukerParameters.getSEP() + "', ");
        result.append("YON='" + brukerParameters.getYON() + "', ");
        result.append("X64='" + brukerParameters.getX64() + "'");
        result.append("}");
        return result.toString();
    }

    public static String asString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("ADP='1', ");
        result.append("ADT=0, ");
        result.append("APF='B3', ");
        result.append("APT='Open', ");
        result.append("AQM='DD', ");
        result.append("BMS='CaF2', ");
        result.append("BSF='C:\\OPUS_7.0.129\\', ");
        result.append("CHN='Module port', ");
        result.append("CNM='Administrator', ");
        result.append("COF=64, ");
        result.append("DAP='C:\\OPUS_7.0.129\\MEAS3', ");
        result.append("DEL=0, ");
        result.append("DIG=0, ");
        result.append("DLY=0, ");
        result.append("DMX='1', ");
        result.append("DPA=6, ");
        result.append("DPO=6, ");
        result.append("DTC='TE-MCT-PV [Internal]', ");
        result.append("EXP='frank.xpm', ");
        result.append("GSG='ON', ");
        result.append("HFQ=1800.0, ");
        result.append("HFW=8000.0, ");
        result.append("IRS=700, ");
        result.append("HPF='-1', ");
        result.append("LFQ=4000.0, ");
        result.append("LFW=1800.0, ");
        result.append("LPF='-1', ");
        result.append("MIN=1.0, ");
        result.append("MIR=1.0, ");
        result.append("NAM=<snm>, ");
        result.append("NLI=1, ");
        result.append("NSS=32, ");
        result.append("NSR=32, ");
        result.append("OEX='0', ");
        result.append("OPF='Open', ");
        result.append("PGN='1', ");
        result.append("PGR='1', ");
        result.append("PHR=32.0, ");
        result.append("PHZ='PW', ");
        result.append("PLF='AB', ");
        result.append("PTH='C:\\OPUS_7.0.129\\MEAS3\\', ");
        result.append("RCH='Module port', ");
        result.append("RES=1.0, ");
        result.append("RGN='-1', ");
        result.append("SAN='Test24.1.dpt', ");
        result.append("SEP=',', ");
        result.append("SFM='MATRIX-MF', ");
        result.append("SGN='-1', ");
        result.append("SNM='Test24', ");
        result.append("SON='Off', ");
        result.append("VEL='40.0', ");
        result.append("X64='0', ");
        result.append("XPP='C:\\OPUS_7.0.129\\XPM', ");
        result.append("YON='0', ");
        result.append("ZFF='4'");

        result.append("}");
        return result.toString();
    }
}
