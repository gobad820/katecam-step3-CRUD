package katecam.step3.crud.repository;

import katecam.step3.crud.domain.Accompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AccompanyRepository extends JpaRepository<Accompany, Long>,
    JpaSpecificationExecutor<Accompany> {

}