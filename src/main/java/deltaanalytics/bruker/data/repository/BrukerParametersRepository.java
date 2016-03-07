package deltaanalytics.bruker.data.repository;


import deltaanalytics.bruker.data.entity.BrukerParameters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrukerParametersRepository extends JpaRepository<BrukerParameters, Long>, BrukerParametersRepositoryCustom {
    BrukerParameters findByCurrentDefaultTrue();
}
