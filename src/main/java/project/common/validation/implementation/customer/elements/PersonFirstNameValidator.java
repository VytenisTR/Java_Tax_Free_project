package project.common.validation.implementation.customer.elements;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.customer.elements.ValidPersonFirstName;

public final class PersonFirstNameValidator implements ConstraintValidator<ValidPersonFirstName, String> {
    @Override
    public boolean isValid(final String personFirstName, final ConstraintValidatorContext context) {
        if (personFirstName == null || personFirstName.trim().isEmpty()) {
            return true;
        }

        return personFirstName.matches("^[A-Za-zÀ-ž]{1,200}$");
    }
}
