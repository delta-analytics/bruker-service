package deltaanalytics.bruker.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MoleculeResult {
    private long id;
    private double ppmH2O;
    private double ppmCO2;
    private double ppmN2O;
    private double ppmCO;
    private double ppmCH4;
    private double ppmNO;
    private double ppmNO2;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPpmH2O() {
        return ppmH2O;
    }

    public void setPpmH2O(double ppmH2O) {
        this.ppmH2O = ppmH2O;
    }

    public double getPpmCO2() {
        return ppmCO2;
    }

    public void setPpmCO2(double ppmCO2) {
        this.ppmCO2 = ppmCO2;
    }

    public double getPpmN2O() {
        return ppmN2O;
    }

    public void setPpmN2O(double ppmN2O) {
        this.ppmN2O = ppmN2O;
    }

    public double getPpmCO() {
        return ppmCO;
    }

    public void setPpmCO(double ppmCO) {
        this.ppmCO = ppmCO;
    }

    public double getPpmCH4() {
        return ppmCH4;
    }

    public void setPpmCH4(double ppmCH4) {
        this.ppmCH4 = ppmCH4;
    }

    public double getPpmNO() {
        return ppmNO;
    }

    public void setPpmNO(double ppmNO) {
        this.ppmNO = ppmNO;
    }

    public double getPpmNO2() {
        return ppmNO2;
    }

    public void setPpmNO2(double ppmNO2) {
        this.ppmNO2 = ppmNO2;
    }

    @Override
    public String toString() {
        return "MeasureSampleMoleculeResult{" +
                "ppmNO2=" + ppmNO2 +
                ", ppmNO=" + ppmNO +
                ", ppmCH4=" + ppmCH4 +
                ", ppmCO=" + ppmCO +
                ", ppmN2O=" + ppmN2O +
                ", ppmCO2=" + ppmCO2 +
                ", ppmH2O=" + ppmH2O +
                '}';
    }
}
