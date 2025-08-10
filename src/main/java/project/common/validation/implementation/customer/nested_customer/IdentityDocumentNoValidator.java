package project.common.validation.implementation.customer.nested_customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.customer.elements.ValidIdentityDocumentNo;

public final class IdentityDocumentNoValidator implements ConstraintValidator<ValidIdentityDocumentNo, String> {
    @Override
    public boolean isValid(final String identityDocumentNo, final ConstraintValidatorContext context) {
        if (identityDocumentNo == null || identityDocumentNo.trim().isEmpty()) {
            return true;
        }

        return identityDocumentNo.matches("^[\\p{L}\\p{N}/-]{1,50}$");
    }
}
