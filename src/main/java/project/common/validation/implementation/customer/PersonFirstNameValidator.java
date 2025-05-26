package project.common.validation.implementation.customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.customer.ValidPersonFirstName;

public final class PersonFirstNameValidator implements ConstraintValidator<ValidPersonFirstName, String> {
    @Override
    public boolean isValid(final String personFirstName, final ConstraintValidatorContext context) {
        return (!personFirstName.trim().isEmpty() && personFirstName.trim().length() <= 200);
    }
}
