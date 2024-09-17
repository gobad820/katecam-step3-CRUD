package katecam.step3.crud.dto;

import jakarta.validation.constraints.NotBlank;
import katecam.step3.crud.annotation.ValidCancelReason;

/**
 * DTO for {@link katecam.step3.crud.domain.Reservation}
 */
public record CancelDto(
    @ValidCancelReason
    String cancelReason,
    @NotBlank(message = "취소 상세 이유는 필수 입력값입니다.")
    String cancelDetail) {

}