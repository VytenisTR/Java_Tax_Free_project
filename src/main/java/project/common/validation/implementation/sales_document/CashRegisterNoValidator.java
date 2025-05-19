package project.common.validation.implementation.sales_document;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.sales_document.ValidCashRegisterNo;

public final class CashRegisterNoValidator implements ConstraintValidator<ValidCashRegisterNo, String> {
    @Override
    public boolean isValid(final String cashRegisterNo, final ConstraintValidatorContext context) {
        return (!cashRegisterNo.trim().isEmpty() && cashRegisterNo.trim().length() <= 50);
    }
}
