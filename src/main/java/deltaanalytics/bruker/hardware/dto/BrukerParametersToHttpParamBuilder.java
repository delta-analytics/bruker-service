package deltaanalytics.bruker.hardware.dto;


import deltaanalytics.bruker.data.entity.BrukerParameters;

public class BrukerParametersToHttpParamBuilder {
    public static String build(BrukerParameters brukerParameters) {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("ADP='" + brukerParameters.getADP() + "', ");
        result.append("ADT=" + brukerParameters.getADT() + ", ");
        result.append("APF='" + brukerParameters.getAPF() + "', ");
        result.append("APT='" + brukerParameters.getAPT() + "', ");
        result.append("AQM='" + brukerParameters.getAQM() + "', ");
        result.append("BMS='" + brukerParameters.getBMS() + "', ");
        result.append("BSF='" + brukerParameters.getBSF() + "', ");
        result.append("CHN='" + brukerParameters.getCHN() + "', ");
        result.append("CNM='" + brukerParameters.getCNM() + "', ");
        result.append("COF=" + brukerParameters.getCOF() + ", ");
        result.append("DAP='" + brukerParameters.getDAP() + "', ");
        result.append("DEL=" + brukerParameters.getDEL() + ", ");
        result.append("DIG=" + brukerParameters.getDIG() + ", ");
        result.append("DLY=" + brukerParameters.getDLY() + ", ");
        result.append("DMX='" + brukerParameters.getDMX() + "', ");
        result.append("DPA=" + brukerParameters.getDPA() + ", ");
        result.append("DPO=" + brukerParameters.getDPO() + ", ");
        result.append("DTC='" + brukerParameters.getDTC() + "', ");
        result.append("EXP='" + brukerParameters.getEXP() + "', ");
        result.append("GSG='" + brukerParameters.getGSG() + "', ");
        result.append("HFQ=" + brukerParameters.getHFQ() + ", ");
        result.append("HFW=" + brukerParameters.getHFW() + ", ");
        result.append("IRS=" + brukerParameters.getIRS() + ", ");
        result.append("HPF='" + brukerParameters.getHPF() + "', ");
        result.append("LFQ=" + brukerParameters.getLFQ() + ", ");
        result.append("LFW=" + brukerParameters.getLFW() + ", ");
        result.append("LPF='" + brukerParameters.getLPF() + "', ");
        result.append("MIN=" + brukerParameters.getMIN() + ", ");
        result.append("MIR=" + brukerParameters.getMIR() + ", ");
        result.append("NAM=" + brukerParameters.getNAM() + ", ");
        result.append("NLI=" + brukerParameters.getNLI() + ", ");
        result.append("NSS=" + brukerParameters.getNSS() + ", ");
        result.append("NSR=" + brukerParameters.getNSR() + ", ");
        result.append("OEX='" + brukerParameters.getOEX() + "', ");
        result.append("OPF='" + brukerParameters.getOPF() + "', ");
        result.append("PGN='" + brukerParameters.getPGN() + "', ");
        result.append("PGR='" + brukerParameters.getPGR() + "', ");
        result.append("PHR=" + brukerParameters.getPHR() + ", ");
        result.append("PHZ='" + brukerParameters.getPHZ() + "', ");
        result.append("PLF='" + brukerParameters.getPLF() + "', ");
        result.append("PTH='" + brukerParameters.getPTH() + "', ");
        result.append("RCH='" + brukerParameters.getRCH() + "', ");
        result.append("RES=" + brukerParameters.getRES() + ", ");
        result.append("RGN='" + brukerParameters.getRGN() + "', ");
        result.append("SAN='" + brukerParameters.getSAN() + "', ");
        result.append("SEP='" + brukerParameters.getSEP() + "', ");
        result.append("SFM='" + brukerParameters.getSFM() + "', ");
        result.append("SGN='" + brukerParameters.getSGN() + "', ");
        result.append("SNM='" + brukerParameters.getSNM() + "', ");
        result.append("SON='" + brukerParameters.getSON() + "', ");
        result.append("VEL='" + brukerParameters.getVEL() + "', ");
        result.append("X64='" + brukerParameters.getX64() + "', ");
        result.append("XPP='" + brukerParameters.getXPP() + "', ");
        result.append("YON='" + brukerParameters.getYON() + "', ");
        result.append("ZFF='" + brukerParameters.getZFF() + "'");

        result.append("}");
        return result.toString();
    }
}
