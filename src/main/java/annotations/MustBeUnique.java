package annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
public @interface MustBeUnique {

    String message() default "username already in use";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
