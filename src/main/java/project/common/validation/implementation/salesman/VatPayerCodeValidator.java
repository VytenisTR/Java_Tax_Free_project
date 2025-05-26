package project.common.validation.implementation.salesman;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.salesman.ValidVatPayerCode;

public final class VatPayerCodeValidator implements ConstraintValidator<ValidVatPayerCode, Long> {
    @Override
    public boolean isValid(final Long vatPayerCode, final ConstraintValidatorContext context) {
        return (vatPayerCode.toString().trim().length() == 9 || vatPayerCode.toString().trim().length() == 12);
    }
}
