package deltaanalytics.bruker.data.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MeasureSample {
    private long id;
    private List<MeasureSampleResult> measureSampleResults = new ArrayList<>();
    private BrukerParameters brukerParameters;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private BrukerStateEnum brukerStateEnum;
    private String filename;
    private String error;

    @JsonView(View.SmallSummary.class)
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

    @OneToMany(cascade = CascadeType.ALL)
    public List<MeasureSampleResult> getMeasureSampleResults() {
        return measureSampleResults;
    }

    public void setMeasureSampleResults(List<MeasureSampleResult> measureSampleResults) {
        this.measureSampleResults = measureSampleResults;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public BrukerParameters getBrukerParameters() {
        return brukerParameters;
    }

    public void setBrukerParameters(BrukerParameters brukerParameters) {
        this.brukerParameters = brukerParameters;
    }

    @JsonView(View.SmallSummary.class)
    @Column
    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }

    @JsonView(View.SmallSummary.class)
    @Column
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
