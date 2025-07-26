package project.common.validation.implementation.sales_document.elements;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.sales_document.elements.ValidCashReceiptNo;

public final class CashReceiptNoValidator implements ConstraintValidator<ValidCashReceiptNo, String> {
    @Override
    public boolean isValid(final String cashReceiptNo, final ConstraintValidatorContext context) {
        if (cashReceiptNo == null || cashReceiptNo.trim().isEmpty()) {
            return true;
        }

        return cashReceiptNo.matches("^[\\p{L}\\p{N}/-]{1,70}$");
    }
}
