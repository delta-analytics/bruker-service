package deltaanalytics.bruker.data.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BrukerParameters{
    private long id;
    private MeasureSample measureSample;
    private boolean currentDefault;
    private String ADP;
    private int ADT;
    //ToDo Liste in GUI
    private String APF;
    //ToDo Liste in GUI
    private String APT;
    //ToDo Liste in GUI
    private String AQM;
    private String BMS;
    private String BSF;
    private String CHN;
    private String CNM;
    private int COF;
    private String DAP;
    private int DEL;
    private int DIG;
    private int DLY;
    private String DMX;
    private int DPA;
    private int DPO;
    private String DTC;
    private String EXP;
    private String GSG;
    private double HFQ;
    private double HFW;
    private int IRS;
    private int HPF;
    private double LFQ;
    private double LFW;
    private String LPF;
    private double MIN;
    private double MIR;
    private String NAM;
    private int NLI;
    private int NSS;
    private int NSR;
    private String OEX;
    private String OPF;
    private String PGN;
    private String PGR;
    private double PHR;
    //ToDo Liste in GUI
    private String PHZ;
    //ToDo Liste in GUI
    private String PLF;
    private String PTH;
    private String RCH;
    private double RES;
    private String RGN;
    private String SAN;
    private String SEP;
    private String SFM;
    private String SGN;
    private String SNM;
    private String SON;
    private String VEL;
    private String X64;
    private String XPP;
    private String YON;
    private String ZFF;
    private String INP;
    private String IFP;
    private String INM;
    private String IFN;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne
    public MeasureSample getMeasureSample() {
        return measureSample;
    }

    public void setMeasureSample(MeasureSample measureSample) {
        this.measureSample = measureSample;
    }

    public String getADP() {
        return ADP;
    }

    public void setADP(String ADP) {
        this.ADP = ADP;
    }

    public int getADT() {
        return ADT;
    }

    public void setADT(int ADT) {
        this.ADT = ADT;
    }

    public String getAPF() {
        return APF;
    }

    public void setAPF(String APF) {
        this.APF = APF;
    }

    public String getAPT() {
        return APT;
    }

    public void setAPT(String APT) {
        this.APT = APT;
    }

    public String getAQM() {
        return AQM;
    }

    public void setAQM(String AQM) {
        this.AQM = AQM;
    }

    public String getBMS() {
        return BMS;
    }

    public void setBMS(String BMS) {
        this.BMS = BMS;
    }

    public String getBSF() {
        return BSF;
    }

    public void setBSF(String BSF) {
        this.BSF = BSF;
    }

    public String getCHN() {
        return CHN;
    }

    public void setCHN(String CHN) {
        this.CHN = CHN;
    }

    public String getCNM() {
        return CNM;
    }

    public void setCNM(String CNM) {
        this.CNM = CNM;
    }

    public int getCOF() {
        return COF;
    }

    public void setCOF(int COF) {
        this.COF = COF;
    }

    public String getDAP() {
        return DAP;
    }

    public void setDAP(String DAP) {
        this.DAP = DAP;
    }

    public int getDEL() {
        return DEL;
    }

    public void setDEL(int DEL) {
        this.DEL = DEL;
    }

    public int getDIG() {
        return DIG;
    }

    public void setDIG(int DIG) {
        this.DIG = DIG;
    }

    public int getDLY() {
        return DLY;
    }

    public void setDLY(int DLY) {
        this.DLY = DLY;
    }

    public String getDMX() {
        return DMX;
    }

    public void setDMX(String DMX) {
        this.DMX = DMX;
    }

    public int getDPA() {
        return DPA;
    }

    public void setDPA(int DPA) {
        this.DPA = DPA;
    }

    public int getDPO() {
        return DPO;
    }

    public void setDPO(int DPO) {
        this.DPO = DPO;
    }

    public String getDTC() {
        return DTC;
    }

    public void setDTC(String DTC) {
        this.DTC = DTC;
    }

    public String getEXP() {
        return EXP;
    }

    public void setEXP(String EXP) {
        this.EXP = EXP;
    }

    public String getGSG() {
        return GSG;
    }

    public void setGSG(String GSG) {
        this.GSG = GSG;
    }

    public double getHFQ() {
        return HFQ;
    }

    public void setHFQ(double HFQ) {
        this.HFQ = HFQ;
    }

    public double getHFW() {
        return HFW;
    }

    public void setHFW(double HFW) {
        this.HFW = HFW;
    }

    public int getIRS() {
        return IRS;
    }

    public void setIRS(int IRS) {
        this.IRS = IRS;
    }

    public int getHPF() {
        return HPF;
    }

    public void setHPF(int HPF) {
        this.HPF = HPF;
    }

    public double getLFQ() {
        return LFQ;
    }

    public void setLFQ(double LFQ) {
        this.LFQ = LFQ;
    }

    public double getLFW() {
        return LFW;
    }

    public void setLFW(double LFW) {
        this.LFW = LFW;
    }

    public String getLPF() {
        return LPF;
    }

    public void setLPF(String LPF) {
        this.LPF = LPF;
    }

    public double getMIN() {
        return MIN;
    }

    public void setMIN(double MIN) {
        this.MIN = MIN;
    }

    public double getMIR() {
        return MIR;
    }

    public void setMIR(double MIR) {
        this.MIR = MIR;
    }

    public String getNAM() {
        return NAM;
    }

    public void setNAM(String NAM) {
        this.NAM = NAM;
    }

    public int getNLI() {
        return NLI;
    }

    public void setNLI(int NLI) {
        this.NLI = NLI;
    }

    public int getNSS() {
        return NSS;
    }

    public void setNSS(int NSS) {
        this.NSS = NSS;
    }

    public int getNSR() {
        return NSR;
    }

    public void setNSR(int NSR) {
        this.NSR = NSR;
    }

    public String getOEX() {
        return OEX;
    }

    public void setOEX(String OEX) {
        this.OEX = OEX;
    }

    public String getOPF() {
        return OPF;
    }

    public void setOPF(String OPF) {
        this.OPF = OPF;
    }

    public String getPGN() {
        return PGN;
    }

    public void setPGN(String PGN) {
        this.PGN = PGN;
    }

    public String getPGR() {
        return PGR;
    }

    public void setPGR(String PGR) {
        this.PGR = PGR;
    }

    public double getPHR() {
        return PHR;
    }

    public void setPHR(double PHR) {
        this.PHR = PHR;
    }

    public String getPHZ() {
        return PHZ;
    }

    public void setPHZ(String PHZ) {
        this.PHZ = PHZ;
    }

    public String getPLF() {
        return PLF;
    }

    public void setPLF(String PLF) {
        this.PLF = PLF;
    }

    public String getPTH() {
        return PTH;
    }

    public void setPTH(String PTH) {
        this.PTH = PTH;
    }

    public String getRCH() {
        return RCH;
    }

    public void setRCH(String RCH) {
        this.RCH = RCH;
    }

    public double getRES() {
        return RES;
    }

    public void setRES(double RES) {
        this.RES = RES;
    }

    public String getRGN() {
        return RGN;
    }

    public void setRGN(String RGN) {
        this.RGN = RGN;
    }

    public String getSAN() {
        return SAN;
    }

    public void setSAN(String SAN) {
        this.SAN = SAN;
    }

    public String getSEP() {
        return SEP;
    }

    public void setSEP(String SEP) {
        this.SEP = SEP;
    }

    public String getSFM() {
        return SFM;
    }

    public void setSFM(String SFM) {
        this.SFM = SFM;
    }

    public String getSGN() {
        return SGN;
    }

    public void setSGN(String SGN) {
        this.SGN = SGN;
    }

    public String getSNM() {
        return SNM;
    }

    public void setSNM(String SNM) {
        this.SNM = SNM;
    }

    public String getSON() {
        return SON;
    }

    public void setSON(String SON) {
        this.SON = SON;
    }

    public String getVEL() {
        return VEL;
    }

    public void setVEL(String VEL) {
        this.VEL = VEL;
    }

    public String getX64() {
        return X64;
    }

    public void setX64(String x64) {
        X64 = x64;
    }

    public String getXPP() {
        return XPP;
    }

    public void setXPP(String XPP) {
        this.XPP = XPP;
    }

    public String getYON() {
        return YON;
    }

    public void setYON(String YON) {
        this.YON = YON;
    }

    public String getZFF() {
        return ZFF;
    }

    public void setZFF(String ZFF) {
        this.ZFF = ZFF;
    }

    public static BrukerParameters getDefault() {
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
        brukerDefaultParameters.setIFP("C:\\OPUS_7.0.129\\METHODS");
        brukerDefaultParameters.setINP("C:\\OPUS_7.0.129\\METHODS");
        brukerDefaultParameters.setINM("DEFAULT");
        brukerDefaultParameters.setIFN("DEFAULT");
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
        brukerDefaultParameters.setSAN("Test24");
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
        brukerDefaultParameters.setCurrentDefault(true);
        return brukerDefaultParameters;
    }

    public boolean isCurrentDefault() {
        return currentDefault;
    }

    public void setCurrentDefault(boolean currentDefault) {
        this.currentDefault = currentDefault;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrukerParameters that = (BrukerParameters) o;

        if (currentDefault != that.currentDefault) return false;
        if (ADT != that.ADT) return false;
        if (COF != that.COF) return false;
        if (DEL != that.DEL) return false;
        if (DIG != that.DIG) return false;
        if (DLY != that.DLY) return false;
        if (DPA != that.DPA) return false;
        if (DPO != that.DPO) return false;
        if (Double.compare(that.HFQ, HFQ) != 0) return false;
        if (Double.compare(that.HFW, HFW) != 0) return false;
        if (IRS != that.IRS) return false;
        if (HPF != that.HPF) return false;
        if (Double.compare(that.LFQ, LFQ) != 0) return false;
        if (Double.compare(that.LFW, LFW) != 0) return false;
        if (Double.compare(that.MIN, MIN) != 0) return false;
        if (Double.compare(that.MIR, MIR) != 0) return false;
        if (NLI != that.NLI) return false;
        if (NSS != that.NSS) return false;
        if (NSR != that.NSR) return false;
        if (Double.compare(that.PHR, PHR) != 0) return false;
        if (Double.compare(that.RES, RES) != 0) return false;
        if (measureSample != null ? !measureSample.equals(that.measureSample) : that.measureSample != null)
            return false;
        if (ADP != null ? !ADP.equals(that.ADP) : that.ADP != null) return false;
        if (APF != null ? !APF.equals(that.APF) : that.APF != null) return false;
        if (APT != null ? !APT.equals(that.APT) : that.APT != null) return false;
        if (AQM != null ? !AQM.equals(that.AQM) : that.AQM != null) return false;
        if (BMS != null ? !BMS.equals(that.BMS) : that.BMS != null) return false;
        if (BSF != null ? !BSF.equals(that.BSF) : that.BSF != null) return false;
        if (CHN != null ? !CHN.equals(that.CHN) : that.CHN != null) return false;
        if (CNM != null ? !CNM.equals(that.CNM) : that.CNM != null) return false;
        if (DAP != null ? !DAP.equals(that.DAP) : that.DAP != null) return false;
        if (DMX != null ? !DMX.equals(that.DMX) : that.DMX != null) return false;
        if (DTC != null ? !DTC.equals(that.DTC) : that.DTC != null) return false;
        if (EXP != null ? !EXP.equals(that.EXP) : that.EXP != null) return false;
        if (GSG != null ? !GSG.equals(that.GSG) : that.GSG != null) return false;
        if (LPF != null ? !LPF.equals(that.LPF) : that.LPF != null) return false;
        if (NAM != null ? !NAM.equals(that.NAM) : that.NAM != null) return false;
        if (OEX != null ? !OEX.equals(that.OEX) : that.OEX != null) return false;
        if (OPF != null ? !OPF.equals(that.OPF) : that.OPF != null) return false;
        if (PGN != null ? !PGN.equals(that.PGN) : that.PGN != null) return false;
        if (PGR != null ? !PGR.equals(that.PGR) : that.PGR != null) return false;
        if (PHZ != null ? !PHZ.equals(that.PHZ) : that.PHZ != null) return false;
        if (PLF != null ? !PLF.equals(that.PLF) : that.PLF != null) return false;
        if (PTH != null ? !PTH.equals(that.PTH) : that.PTH != null) return false;
        if (RCH != null ? !RCH.equals(that.RCH) : that.RCH != null) return false;
        if (RGN != null ? !RGN.equals(that.RGN) : that.RGN != null) return false;
        if (SAN != null ? !SAN.equals(that.SAN) : that.SAN != null) return false;
        if (SEP != null ? !SEP.equals(that.SEP) : that.SEP != null) return false;
        if (SFM != null ? !SFM.equals(that.SFM) : that.SFM != null) return false;
        if (SGN != null ? !SGN.equals(that.SGN) : that.SGN != null) return false;
        if (SNM != null ? !SNM.equals(that.SNM) : that.SNM != null) return false;
        if (SON != null ? !SON.equals(that.SON) : that.SON != null) return false;
        if (VEL != null ? !VEL.equals(that.VEL) : that.VEL != null) return false;
        if (X64 != null ? !X64.equals(that.X64) : that.X64 != null) return false;
        if (XPP != null ? !XPP.equals(that.XPP) : that.XPP != null) return false;
        if (YON != null ? !YON.equals(that.YON) : that.YON != null) return false;
        if (ZFF != null ? !ZFF.equals(that.ZFF) : that.ZFF != null) return false;
        if (INP != null ? !INP.equals(that.INP) : that.INP != null) return false;
        if (IFP != null ? !IFP.equals(that.IFP) : that.IFP != null) return false;
        if (INM != null ? !INM.equals(that.INM) : that.INM != null) return false;
        return !(IFN != null ? !IFN.equals(that.IFN) : that.IFN != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = measureSample != null ? measureSample.hashCode() : 0;
        result = 31 * result + (currentDefault ? 1 : 0);
        result = 31 * result + (ADP != null ? ADP.hashCode() : 0);
        result = 31 * result + ADT;
        result = 31 * result + (APF != null ? APF.hashCode() : 0);
        result = 31 * result + (APT != null ? APT.hashCode() : 0);
        result = 31 * result + (AQM != null ? AQM.hashCode() : 0);
        result = 31 * result + (BMS != null ? BMS.hashCode() : 0);
        result = 31 * result + (BSF != null ? BSF.hashCode() : 0);
        result = 31 * result + (CHN != null ? CHN.hashCode() : 0);
        result = 31 * result + (CNM != null ? CNM.hashCode() : 0);
        result = 31 * result + COF;
        result = 31 * result + (DAP != null ? DAP.hashCode() : 0);
        result = 31 * result + DEL;
        result = 31 * result + DIG;
        result = 31 * result + DLY;
        result = 31 * result + (DMX != null ? DMX.hashCode() : 0);
        result = 31 * result + DPA;
        result = 31 * result + DPO;
        result = 31 * result + (DTC != null ? DTC.hashCode() : 0);
        result = 31 * result + (EXP != null ? EXP.hashCode() : 0);
        result = 31 * result + (GSG != null ? GSG.hashCode() : 0);
        temp = Double.doubleToLongBits(HFQ);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(HFW);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + IRS;
        result = 31 * result + HPF;
        temp = Double.doubleToLongBits(LFQ);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(LFW);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (LPF != null ? LPF.hashCode() : 0);
        temp = Double.doubleToLongBits(MIN);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(MIR);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (NAM != null ? NAM.hashCode() : 0);
        result = 31 * result + NLI;
        result = 31 * result + NSS;
        result = 31 * result + NSR;
        result = 31 * result + (OEX != null ? OEX.hashCode() : 0);
        result = 31 * result + (OPF != null ? OPF.hashCode() : 0);
        result = 31 * result + (PGN != null ? PGN.hashCode() : 0);
        result = 31 * result + (PGR != null ? PGR.hashCode() : 0);
        temp = Double.doubleToLongBits(PHR);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (PHZ != null ? PHZ.hashCode() : 0);
        result = 31 * result + (PLF != null ? PLF.hashCode() : 0);
        result = 31 * result + (PTH != null ? PTH.hashCode() : 0);
        result = 31 * result + (RCH != null ? RCH.hashCode() : 0);
        temp = Double.doubleToLongBits(RES);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (RGN != null ? RGN.hashCode() : 0);
        result = 31 * result + (SAN != null ? SAN.hashCode() : 0);
        result = 31 * result + (SEP != null ? SEP.hashCode() : 0);
        result = 31 * result + (SFM != null ? SFM.hashCode() : 0);
        result = 31 * result + (SGN != null ? SGN.hashCode() : 0);
        result = 31 * result + (SNM != null ? SNM.hashCode() : 0);
        result = 31 * result + (SON != null ? SON.hashCode() : 0);
        result = 31 * result + (VEL != null ? VEL.hashCode() : 0);
        result = 31 * result + (X64 != null ? X64.hashCode() : 0);
        result = 31 * result + (XPP != null ? XPP.hashCode() : 0);
        result = 31 * result + (YON != null ? YON.hashCode() : 0);
        result = 31 * result + (ZFF != null ? ZFF.hashCode() : 0);
        result = 31 * result + (INP != null ? INP.hashCode() : 0);
        result = 31 * result + (IFP != null ? IFP.hashCode() : 0);
        result = 31 * result + (INM != null ? INM.hashCode() : 0);
        result = 31 * result + (IFN != null ? IFN.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BrukerParameters{" +
                "id=" + id +
                ", measureSample=" + measureSample +
                ", currentDefault=" + currentDefault +
                ", ADP='" + ADP + '\'' +
                ", ADT=" + ADT +
                ", APF='" + APF + '\'' +
                ", APT='" + APT + '\'' +
                ", AQM='" + AQM + '\'' +
                ", BMS='" + BMS + '\'' +
                ", BSF='" + BSF + '\'' +
                ", CHN='" + CHN + '\'' +
                ", CNM='" + CNM + '\'' +
                ", COF=" + COF +
                ", DAP='" + DAP + '\'' +
                ", DEL=" + DEL +
                ", DIG=" + DIG +
                ", DLY=" + DLY +
                ", DMX='" + DMX + '\'' +
                ", DPA=" + DPA +
                ", DPO=" + DPO +
                ", DTC='" + DTC + '\'' +
                ", EXP='" + EXP + '\'' +
                ", GSG='" + GSG + '\'' +
                ", HFQ=" + HFQ +
                ", HFW=" + HFW +
                ", IRS=" + IRS +
                ", HPF=" + HPF +
                ", LFQ=" + LFQ +
                ", LFW=" + LFW +
                ", LPF='" + LPF + '\'' +
                ", MIN=" + MIN +
                ", MIR=" + MIR +
                ", NAM='" + NAM + '\'' +
                ", NLI=" + NLI +
                ", NSS=" + NSS +
                ", NSR=" + NSR +
                ", OEX='" + OEX + '\'' +
                ", OPF='" + OPF + '\'' +
                ", PGN='" + PGN + '\'' +
                ", PGR='" + PGR + '\'' +
                ", PHR=" + PHR +
                ", PHZ='" + PHZ + '\'' +
                ", PLF='" + PLF + '\'' +
                ", PTH='" + PTH + '\'' +
                ", RCH='" + RCH + '\'' +
                ", RES=" + RES +
                ", RGN='" + RGN + '\'' +
                ", SAN='" + SAN + '\'' +
                ", SEP='" + SEP + '\'' +
                ", SFM='" + SFM + '\'' +
                ", SGN='" + SGN + '\'' +
                ", SNM='" + SNM + '\'' +
                ", SON='" + SON + '\'' +
                ", VEL='" + VEL + '\'' +
                ", X64='" + X64 + '\'' +
                ", XPP='" + XPP + '\'' +
                ", YON='" + YON + '\'' +
                ", ZFF='" + ZFF + '\'' +
                ", INP='" + INP + '\'' +
                ", IFP='" + IFP + '\'' +
                ", INM='" + INM + '\'' +
                ", IFN='" + IFN + '\'' +
                '}';
    }

    public String getINP() {
        return INP;
    }

    public void setINP(String INP) {
        this.INP = INP;
    }

    public String getIFP() {
        return IFP;
    }

    public void setIFP(String IFP) {
        this.IFP = IFP;
    }

    public String getINM() {
        return INM;
    }

    public void setINM(String INM) {
        this.INM = INM;
    }

    public String getIFN() {
        return IFN;
    }

    public void setIFN(String IFN) {
        this.IFN = IFN;
    }
}
