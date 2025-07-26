package project.common.validation.implementation.salesman;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.salesman.ValidVatPayerCode;

public final class VatPayerCodeValidator implements ConstraintValidator<ValidVatPayerCode, String> {
    @Override
    public boolean isValid(final String vatPayerCode, final ConstraintValidatorContext context) {
        if (vatPayerCode == null || vatPayerCode.trim().isEmpty()) {
            return true;
        }

        return vatPayerCode.matches("^LT(\\d{9}|\\d{12})$");
    }
}
