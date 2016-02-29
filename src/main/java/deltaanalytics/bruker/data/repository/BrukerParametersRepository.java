package deltaanalytics.bruker.data.repository;


import deltaanalytics.bruker.data.entity.BrukerParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;

public class BrukerParametersRepository extends BrukerDataRepository<BrukerParameters> {
    private static final Logger logger = LoggerFactory.getLogger(BrukerParametersRepository.class);
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
        try {
            BrukerParameters currentActive = readCurrentActiveDefault();
            currentActive.setCurrentDefault(false);
            super.createOrUpdate(currentActive);
        } catch (NoResultException noRes){
            logger.warn("No active BrukerParameters");
        }
        brukerParameters.setCurrentDefault(true);
        super.createOrUpdate(brukerParameters);
    }
}
