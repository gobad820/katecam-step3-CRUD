package katecam.step3.crud.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import katecam.step3.crud.annotation.ValidDepartureLocation;

public class DepartureLocationValidator implements ConstraintValidator<ValidDepartureLocation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) { context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("출발지는 필수 입력값입니다.")
                   .addConstraintViolation();
            return false;
        }
        return true;
    }
}