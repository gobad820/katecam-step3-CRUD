package katecam.step3.crud.service;

import katecam.step3.crud.domain.Reservation;
import katecam.step3.crud.dto.ApiDto;
import katecam.step3.crud.dto.ReservationDto;
import katecam.step3.crud.enumdomain.CancelReason;
import katecam.step3.crud.repository.ReservationRepository;
import org.springframework.http.HttpStatus;

public class ReservationService {

    private ReservationRepository reservationRepository;

    // 예약 작성
    public ApiDto<Reservation> createReservation(ReservationDto reservationDto) {
        try {
            Reservation reservation = new Reservation(reservationDto.departureLocation(),
                reservationDto.arrivalLocation(),
                reservationDto.reservationDateTime(), reservationDto.serviceType(),
                reservationDto.transportation(), reservationDto.price());
            reservationRepository.save(reservation);
            return new ApiDto<>(reservation, "예약이 접수되었습니다", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("보호자 전화번호를 반드시 입력해야 합니다.");
        } // 401 에러는 SpringSecurity에서 처리

    }


    // 예약 취소
    public Reservation cancelReservation(Reservation reservation) {
        // 해당 reservationDTO를 통해 특정 예약을 어떻게 하면 잡아낼 수 있는가?
        checkDetailIsNull(reservation);
        Reservation canceledReservation = reservationRepository.findById(reservation.getId())
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 예약입니다."));
        addCancelResasonAndDetail(reservation.getCancelReason(),reservation.getCancelDetail(), canceledReservation);
        return canceledReservation;
    }

    private static void addCancelResasonAndDetail(CancelReason cancelReason, String cancelDetail, Reservation canceledReservation) {
        canceledReservation.setCancelReason(cancelReason);
        canceledReservation.setCancelDetail(cancelDetail);
    }

    private static void checkDetailIsNull(Reservation reservation) {
        if (reservation.getCancelDetail().isBlank()) {
            throw new IllegalArgumentException("변심 이유를 반드시 선택해야 합니다.");
        }
    }
}
