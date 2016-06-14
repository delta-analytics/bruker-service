package deltaanalytics.bruker.data.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MoleculeResultList {
    private long id;
    private List<MoleculeResult> allMolecules = new ArrayList<>();

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void addMoleculeResult(MoleculeResult moleculeResult) {
        this.allMolecules.add(moleculeResult);
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<MoleculeResult> getMoleculeResultList() {
        return allMolecules;
    }

    public void setMoleculeResultList(List<MoleculeResult> allMolecules) {
        this.allMolecules = allMolecules;
    }
    
    
    @Override
    public String toString() {
        return "MeasureSampleMoleculeResult{" +
                "allMolecules=" + allMolecules.stream().map(Object::toString).collect(Collectors.joining(", ")) +
                '}';
    }
    

}
