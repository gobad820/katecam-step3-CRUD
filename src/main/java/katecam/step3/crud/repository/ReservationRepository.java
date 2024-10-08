package katecam.step3.crud.repository;

import katecam.step3.crud.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>,
    JpaSpecificationExecutor<Reservation> {

}