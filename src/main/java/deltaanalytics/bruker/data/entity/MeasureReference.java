package deltaanalytics.bruker.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MeasureReference {
    private long id;

    private BrukerParameters brukerParameters;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private BrukerStateEnum brukerStateEnum;
    private String error;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

        MeasureReference that = (MeasureReference) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
