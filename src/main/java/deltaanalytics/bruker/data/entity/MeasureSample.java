package deltaanalytics.bruker.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MeasureSample implements BrukerDataEntity {
    private long id;

    private List<MeasureSampleResult> measureSampleResults = new ArrayList<>();
    private BrukerParameters brukerParameters;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private BrukerStateEnum brukerStateEnum;
    private String filename;
    private String error;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addMeasureSampleResult(MeasureSampleResult measureSampleResult) {
        this.measureSampleResults.add(measureSampleResult);
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<MeasureSampleResult> getMeasureSampleResults() {
        return measureSampleResults;
    }

    public void setMeasureSampleResults(List<MeasureSampleResult> measureSampleResults) {
        this.measureSampleResults = measureSampleResults;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public BrukerParameters getBrukerParameters() {
        return brukerParameters;
    }

    public void setBrukerParameters(BrukerParameters brukerParameters) {
        this.brukerParameters = brukerParameters;
    }

    @Column
    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }

    @Column
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BrukerStateEnum getBrukerStateEnum() {
        return brukerStateEnum;
    }

    public void setBrukerStateEnum(BrukerStateEnum brukerStateEnum) {
        this.brukerStateEnum = brukerStateEnum;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Lob
    @Column
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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
                ", measureSampleResults=" + measureSampleResults +
                ", brukerParameters=" + brukerParameters +
                ", createdAt=" + createdAt +
                ", finishedAt=" + finishedAt +
                ", brukerStateEnum=" + brukerStateEnum +
                ", error='" + error + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
