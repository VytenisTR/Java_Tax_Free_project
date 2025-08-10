package project.common.validation.implementation.customer.nested_customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.customer.elements.ValidResidentialDocumentNo;

public final class ResidentialDocumentNoValidator implements ConstraintValidator<ValidResidentialDocumentNo, String> {
    @Override
    public boolean isValid(final String residentialDocumentNo, final ConstraintValidatorContext context) {
        if (residentialDocumentNo == null || residentialDocumentNo.trim().isEmpty()) {
            return true;
        }

        return residentialDocumentNo.matches("^[\\p{L}\\p{N}/-]{1,50}$");
    }
}
