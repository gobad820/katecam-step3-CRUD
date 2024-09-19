package katecam.step3.crud.repository;

import java.util.Optional;
import katecam.step3.crud.domain.Report;
import katecam.step3.crud.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>,
    JpaSpecificationExecutor<Report> {
    public Optional<Report> findByReservation(Reservation reservation);
}