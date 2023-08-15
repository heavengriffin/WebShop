package annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringValidator.class)
public @interface StringNotEmpty {

    String message() default "must not be empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
