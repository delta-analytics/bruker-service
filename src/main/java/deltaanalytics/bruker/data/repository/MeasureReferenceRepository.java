package deltaanalytics.bruker.data.repository;


import deltaanalytics.bruker.data.entity.MeasureReference;

public class MeasureReferenceRepository extends BrukerDataRepository<MeasureReference> {
    @Override
    public boolean exists(MeasureReference entity) {
        return read(entity.getId()) != null;
    }

    @Override
    protected Class<MeasureReference> getEntityClass() {
        return MeasureReference.class;
    }
}
