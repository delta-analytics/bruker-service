package deltaanalytics.bruker.data.repository;


import deltaanalytics.bruker.data.entity.BrukerParameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BrukerParametersRepositoryCustom {

    void saveAndMarkNewDefaults(BrukerParameters brukerParameters);
}
