package katecam.step3.crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDateTime;
import katecam.step3.crud.enumdomain.AccompanyStatus;
import org.hibernate.validator.constraints.Range;

/**
 * DTO for {@link katecam.step3.crud.domain.Accompany}
 */
public record AccompanyDto(
    @NotNull(message = "진행 상태틑 0자 이상이어야 합니다.") AccompanyStatus accompanyStatus,
    @PositiveOrZero @Range(message = "위도는 0이상 90 이하의 값입니다.", min = 0, max = 90) Double latitude,
    @PositiveOrZero @Range(message = "경도는 0이상 360이하의 값입니다.", min = 0, max = 360) Double longitude,
    @NotNull(message = "시간은 필수 입력 값입니다.") @Past LocalDateTime time,
    @NotBlank(message = "리포트 상세 사항은 필수 사항입니다.") String detail) implements
    Serializable {

}