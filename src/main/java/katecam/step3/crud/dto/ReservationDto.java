package katecam.step3.crud.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import katecam.step3.crud.annotation.ValidArrivalLocation;
import katecam.step3.crud.annotation.ValidDepartureLocation;
import katecam.step3.crud.annotation.ValidPrice;
import katecam.step3.crud.annotation.ValidServiceType;
import katecam.step3.crud.annotation.ValidTransportation;
import katecam.step3.crud.enumdomain.ServiceType;
import katecam.step3.crud.enumdomain.Transportation;
import org.springframework.validation.annotation.Validated;

/**
 * DTO for {@link katecam.step3.crud.domain.Reservation}
 */
@Validated
public record ReservationDto(
    @ValidDepartureLocation String departureLocation,
    @ValidArrivalLocation String arrivalLocation,
    @NotNull(message = "예약 일시를 입력해 주십시오.")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}", message = "잘못된 날짜 형식입니다. 'yyyy-MM-dd HH:mm:ss' 형식으로 입력해주세요.")
    String reservationDateTime,
    @ValidServiceType ServiceType serviceType,
    @ValidTransportation Transportation transportation,
    @Min(value = 0, message = "가격은 0 이상 입니다.") @ValidPrice String price) {

}