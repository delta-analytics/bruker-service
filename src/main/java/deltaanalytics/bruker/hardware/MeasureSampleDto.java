package deltaanalytics.bruker.hardware;


import deltaanalytics.bruker.data.entity.BrukerStateEnum;
import deltaanalytics.bruker.data.entity.MeasureSample;

import java.time.LocalDateTime;

//Klasse für Demo Gui Tableview
public class MeasureSampleDto {
    private long id;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private BrukerStateEnum brukerStateEnum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }

    public BrukerStateEnum getBrukerStateEnum() {
        return brukerStateEnum;
    }

    public void setBrukerStateEnum(BrukerStateEnum brukerStateEnum) {
        this.brukerStateEnum = brukerStateEnum;
    }

    public MeasureSampleDto(MeasureSample measureSample) {
        brukerStateEnum = measureSample.getBrukerStateEnum();
        createdAt = measureSample.getCreatedAt();
        finishedAt = measureSample.getFinishedAt();
        id = measureSample.getId();
    }
}
