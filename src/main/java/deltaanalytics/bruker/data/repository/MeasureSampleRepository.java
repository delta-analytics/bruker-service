package deltaanalytics.bruker.data.repository;


import deltaanalytics.bruker.data.entity.MeasureSample;

public class MeasureSampleRepository extends BrukerDataRepository<MeasureSample> {
    @Override
    public boolean exists(MeasureSample entity) {
        return read(entity.getId()) != null;
    }

    @Override
    protected Class<MeasureSample> getEntityClass() {
        return MeasureSample.class;
    }
}
