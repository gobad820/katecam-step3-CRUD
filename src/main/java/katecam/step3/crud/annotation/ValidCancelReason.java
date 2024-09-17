package katecam.step3.crud.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import katecam.step3.crud.validator.CancelReasonValidator;

@Documented
@Constraint(validatedBy = CancelReasonValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCancelReason {

    String message() default "유효하지 않은 취소 사유입니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
