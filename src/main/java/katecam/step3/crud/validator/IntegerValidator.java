package katecam.step3.crud.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import katecam.step3.crud.annotation.ValidInteger;

public class IntegerValidator implements ConstraintValidator<ValidInteger, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        try {
            int price = Integer.parseInt(value);
            if (price < 0) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("입력값은 0 이상이어야 합니다.")
                    .addConstraintViolation();
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("입력값은 정수여야 합니다.")
                .addConstraintViolation();
            return false;
        }
    }
}
