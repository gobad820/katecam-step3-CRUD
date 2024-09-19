package katecam.step3.crud.service;

import java.util.List;
import katecam.step3.crud.domain.Accompany;
import katecam.step3.crud.domain.Reservation;
import katecam.step3.crud.dto.AccompanyDto;
import katecam.step3.crud.repository.AccompanyRepository;
import katecam.step3.crud.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class AccompanyService {

    private final AccompanyRepository accompanyRepository;
    private final ReservationRepository reservationRepository;

    public AccompanyService(AccompanyRepository accompanyRepository,
        ReservationRepository reservationRepository) {
        this.accompanyRepository = accompanyRepository;
        this.reservationRepository = reservationRepository;
    }

    // 실시간 동행 정보 조회
    public List<Accompany> getTrackingAccompanies(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
            .orElseThrow(IllegalArgumentException::new);
        return reservation.getAccompany();
    }

    // 실시간 동행 정보 생성
    public Accompany getTrackingAccompany(Long reservationId, AccompanyDto accompanyDto) {
        Accompany track = Accompany.builder().accompanyStatus(accompanyDto.accompanyStatus())
            .time(accompanyDto.time()).latitude(accompanyDto.latitude())
            .longitude(accompanyDto.longitude()).longitude(accompanyDto.longitude())
            .detail(accompanyDto.detail()).build();
        Reservation reservation = reservationRepository.findById(reservationId)
            .orElseThrow(IllegalArgumentException::new);
        reservation.getAccompany().add(track);
        reservationRepository.save(reservation);
        accompanyRepository.save(track);
        return track;
    }

}
