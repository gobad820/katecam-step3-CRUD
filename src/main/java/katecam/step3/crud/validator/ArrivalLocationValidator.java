package katecam.step3.crud.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import katecam.step3.crud.annotation.ValidArrivalLocation;

public class ArrivalLocationValidator implements ConstraintValidator<ValidArrivalLocation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("출발지는 필수 입력값입니다.")
                .addConstraintViolation();
            return false;
        }
        return true;
    }
}
