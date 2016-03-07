package deltaanalytics.bruker.data.repository;


import deltaanalytics.bruker.data.entity.MeasureSampleResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasureSampleResultRepository extends JpaRepository<MeasureSampleResult, Long> {
}
