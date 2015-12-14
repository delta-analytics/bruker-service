package deltaanalytics.bruker.data.repository;


import deltaanalytics.bruker.data.entity.MeasureSampleResult;

public class MeasureSampleResultRepository extends BrukerDataRepository<MeasureSampleResult> {
    @Override
    public boolean exists(MeasureSampleResult entity) {
        return read(entity.getId()) != null;
    }

    @Override
    protected Class<MeasureSampleResult> getEntityClass() {
        return MeasureSampleResult.class;
    }
}
