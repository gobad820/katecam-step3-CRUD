package katecam.step3.crud.controller;

import jakarta.validation.Valid;
import katecam.step3.crud.domain.Reservation;
import katecam.step3.crud.dto.ApiDto;
import katecam.step3.crud.dto.CancelDto;
import katecam.step3.crud.dto.ReservationDto;
import katecam.step3.crud.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ApiDto<Reservation> create(@Valid @RequestBody ReservationDto reservationDto) {
        return new ApiDto<>(reservationService.createReservation(reservationDto), "예약이 접수되었습니다",
            HttpStatus.OK);
    }

    @PatchMapping("/cancel/{reservation_id}") // 이미 취소된 것을 다시 또 취소하는 경우 에러 처리 필요
    public ApiDto<Reservation> cancel(@PathVariable Long reservation_id,
        @Valid @RequestBody CancelDto cancelDto) {
        return new ApiDto<>(reservationService.cancelReservation(reservation_id, cancelDto),
            "예약 취소가 접수되었습니다.", HttpStatus.OK);
    }
}
