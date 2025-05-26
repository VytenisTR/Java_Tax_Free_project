package project.common.validation.implementation.customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.customer.ValidPersonalIdNo;

public final class PersonalIdNoValidator implements ConstraintValidator<ValidPersonalIdNo, String> {
    @Override
    public boolean isValid(final String personalIdNumber, final ConstraintValidatorContext context) {
        return (!personalIdNumber.trim().isEmpty() && personalIdNumber.trim().length() <= 50);
    }
}
