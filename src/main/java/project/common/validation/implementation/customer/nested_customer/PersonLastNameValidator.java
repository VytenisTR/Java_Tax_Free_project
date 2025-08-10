package project.common.validation.implementation.customer.nested_customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.customer.elements.ValidPersonLastName;

public final class PersonLastNameValidator implements ConstraintValidator<ValidPersonLastName, String> {
    @Override
    public boolean isValid(final String personLastName, final ConstraintValidatorContext context) {
        if (personLastName == null || personLastName.trim().isEmpty()) {
            return true;
        }

        return personLastName.matches("^[A-Za-zÀ-ž]{1,200}$");
    }
}
