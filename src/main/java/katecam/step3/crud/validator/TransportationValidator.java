package katecam.step3.crud.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import katecam.step3.crud.annotation.ValidTransportation;

public class TransportationValidator implements ConstraintValidator<ValidTransportation, String> {

    private static final List<String> TRANSPORTATION = List.of("도보", "택시");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.isBlank()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("운송 수단은 필수 입력값입니다.")
                .addConstraintViolation();
            return false;
        }

        if (!TRANSPORTATION.contains(value.trim())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "유효하지 않은 운송 수단입니다. 유효한 운송 수단: " + String.join(", ", TRANSPORTATION))
                .addConstraintViolation();
            return false;
        }

        return true;
    }
}
