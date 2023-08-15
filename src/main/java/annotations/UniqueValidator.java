package annotations;

import models.Buyer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValidator implements ConstraintValidator<MustBeUnique, String> {
    @Override
    public void initialize(MustBeUnique mustBeUnique) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        boolean unique = true;
        try {
            List<Buyer> buyers = Buyer.getAllBuyers();
            for (Buyer b : buyers) {
                if (b.getUsername().equals(username)) {
                    unique = false;
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return unique;
    }
}
