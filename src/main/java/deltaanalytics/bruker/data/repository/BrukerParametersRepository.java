package deltaanalytics.bruker.data.repository;


import deltaanalytics.bruker.data.entity.BrukerParameters;

public class BrukerParametersRepository extends BrukerDataRepository<BrukerParameters> {
    @Override
    public boolean exists(BrukerParameters entity) {
        return read(entity.getId()) != null;
    }

    @Override
    protected Class<BrukerParameters> getEntityClass() {
        return BrukerParameters.class;
    }

    public BrukerParameters readCurrentActiveDefault() {
        startDBOperation();
        BrukerParameters currentActive = (BrukerParameters) getEntityManager().createQuery("Select t from " + getEntityClass().getSimpleName() + " t where currentDefault=true").getSingleResult();
        endDBOperation();
        return currentActive;
    }

    public void createOrUpdateAndMakeDefault(BrukerParameters brukerParameters) {
        BrukerParameters currentActive = readCurrentActiveDefault();
        currentActive.setCurrentDefault(false);
        super.createOrUpdate(currentActive);
        brukerParameters.setCurrentDefault(true);
        super.createOrUpdate(brukerParameters);
    }
}
