package deltaanalytics.bruker.data.repository;


import deltaanalytics.bruker.data.entity.MeasureSample;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasureSampleRepository extends JpaRepository<MeasureSample, Long> {
}
