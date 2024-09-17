package katecam.step3.crud.repository;

import katecam.step3.crud.domain.TimeOfDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TimeOfDaysRepository extends JpaRepository<TimeOfDays, Long>,
    JpaSpecificationExecutor<TimeOfDays> {

}