package annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringValidator implements ConstraintValidator<StringNotEmpty, String> {

    @Override
    public void initialize(StringNotEmpty stringNotEmpty) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && !s.equals("");
    }
}
