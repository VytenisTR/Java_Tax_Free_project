package project.common.validation.implementation.customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.customer.ValidResidentialDocumentNo;

public final class ResidentialDocumentNoValidator implements ConstraintValidator<ValidResidentialDocumentNo, String> {
    @Override
    public boolean isValid(final String residentialDocumentNo, final ConstraintValidatorContext context) {
        return (!residentialDocumentNo.trim().isEmpty() && residentialDocumentNo.trim().length() <= 50);
    }
}
