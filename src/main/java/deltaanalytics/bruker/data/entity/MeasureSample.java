package deltaanalytics.bruker.data.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MeasureSample {
    private long id;
    private BrukerParameters brukerParameters;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private BrukerStateEnum brukerStateEnum;
    private String filename;
    private String error;
    private MoleculeResults moleculeResults;

    @JsonView(View.SmallSummary.class)
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public BrukerParameters getBrukerParameters() {
        return brukerParameters;
    }

    public void setBrukerParameters(BrukerParameters brukerParameters) {
        this.brukerParameters = brukerParameters;
    }

    @JsonView(View.SmallSummary.class)
    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }

    @JsonView(View.SmallSummary.class)
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @JsonView(View.SmallSummary.class)
    public BrukerStateEnum getBrukerStateEnum() {
        return brukerStateEnum;
    }

    public void setBrukerStateEnum(BrukerStateEnum brukerStateEnum) {
        this.brukerStateEnum = brukerStateEnum;
    }

    @JsonView(View.SmallSummary.class)
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @JsonView(View.SmallSummary.class)
    @Lob
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public MoleculeResults getMoleculeResults() {
        return moleculeResults;
    }

    public void setMoleculeResults(MoleculeResults moleculeResults) {
        this.moleculeResults = moleculeResults;
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasureSample that = (MeasureSample) o;

        return id == that.id;

    }

    @Override
    public String toString() {
        return "MeasureSample{" +
                "id=" + id +
                ", brukerParameters=" + brukerParameters +
                ", createdAt=" + createdAt +
                ", finishedAt=" + finishedAt +
                ", brukerStateEnum=" + brukerStateEnum +
                ", moleculeResultList=" + moleculeResults +
                ", error='" + error + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
