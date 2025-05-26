package project.common.validation.implementation.customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.customer.ValidPersonLastName;

public final class PersonLastNameValidator implements ConstraintValidator<ValidPersonLastName, String> {
    @Override
    public boolean isValid(final String personLastName, final ConstraintValidatorContext context) {
        return (!personLastName.trim().isEmpty() && personLastName.trim().length() <= 200);
    }
}
