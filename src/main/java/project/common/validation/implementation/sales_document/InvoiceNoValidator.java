package project.common.validation.implementation.sales_document;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.sales_document.ValidInvoiceNo;

public final class InvoiceNoValidator implements ConstraintValidator<ValidInvoiceNo, String> {
    @Override
    public boolean isValid(final String invoiceNo, final ConstraintValidatorContext context) {
        return (!invoiceNo.trim().isEmpty() && invoiceNo.trim().length() <= 70);
    }
}
