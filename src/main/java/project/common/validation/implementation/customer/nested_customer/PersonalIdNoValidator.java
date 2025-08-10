package project.common.validation.implementation.customer.nested_customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.customer.elements.ValidPersonalIdNo;

public final class PersonalIdNoValidator implements ConstraintValidator<ValidPersonalIdNo, String> {
    @Override
    public boolean isValid(final String personalIdNumber, final ConstraintValidatorContext context) {
        if (personalIdNumber == null || personalIdNumber.trim().isEmpty()) {
            return true;
        }

        return personalIdNumber.matches("^[\\p{L}\\p{N}/-]{1,50}$");
    }
}
