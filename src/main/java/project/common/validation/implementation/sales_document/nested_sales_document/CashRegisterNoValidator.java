package project.common.validation.implementation.sales_document.nested_sales_document;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.sales_document.elements.ValidCashRegisterNo;

public final class CashRegisterNoValidator implements ConstraintValidator<ValidCashRegisterNo, String> {
    @Override
    public boolean isValid(final String cashRegisterNo, final ConstraintValidatorContext context) {
        if (cashRegisterNo == null || cashRegisterNo.trim().isEmpty()) {
            return true;
        }

        return cashRegisterNo.matches("^[\\p{L}\\p{N}/-]{1,50}$");
    }
}
