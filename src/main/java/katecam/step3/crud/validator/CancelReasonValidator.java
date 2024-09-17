package katecam.step3.crud.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import katecam.step3.crud.annotation.ValidCancelReason;

public class CancelReasonValidator implements ConstraintValidator<ValidCancelReason, String> {

    private static final List<String> VALID_REASONS = Arrays.asList("단순변심", "피진료자취소", "보호자취소",
        "매니저취소", "매니저매치안됨");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.isBlank()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("취소 이유는 필수 입력값입니다.")
                .addConstraintViolation();
            return false;
        }

        if (!VALID_REASONS.contains(value.trim())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "유효하지 않은 취소 이유입니다. 유효한 이유: " + String.join(", ", VALID_REASONS))
                .addConstraintViolation();
            return false;
        }

        return true;
    }
}
