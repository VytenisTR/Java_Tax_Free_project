package project.common.validation.implementation.customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.customer.ValidIdentityDocumentNo;

public final class IdentityDocumentNoValidator implements ConstraintValidator<ValidIdentityDocumentNo, String> {
    @Override
    public boolean isValid(final String identityDocumentNo, final ConstraintValidatorContext context) {
        return (!identityDocumentNo.trim().isEmpty() && identityDocumentNo.trim().length() <= 50);
    }
}
