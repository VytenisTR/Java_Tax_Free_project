package project.common.validation.implementation.sales_document;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.sales_document.ValidCashReceiptNo;

public final class CashReceiptNoValidator implements ConstraintValidator<ValidCashReceiptNo, String> {
    @Override
    public boolean isValid(final String cashReceiptNo, final ConstraintValidatorContext context) {
        return (!cashReceiptNo.trim().isEmpty() && cashReceiptNo.trim().length() <= 70);
    }
}
