package katecam.step3.crud.dto;

import jakarta.validation.constraints.NotBlank;
import katecam.step3.crud.annotation.ValidFrequency;
import katecam.step3.crud.annotation.ValidMealTime;
import katecam.step3.crud.enumdomain.MealTime;
import org.springframework.validation.annotation.Validated;

@Validated
public record ReportDto(
    @NotBlank(message = "유효하지 않은 의사 소견입니다.") String doctorSummary,
    @ValidFrequency int frequency,
    @ValidMealTime MealTime mealTime,
    @NotBlank(message = "유효하지 않은 복용 횟수입니다") String timeOfDays) {
}
