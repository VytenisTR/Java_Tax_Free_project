package project.common.validation.implementation.sales_document.nested_sales_document;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.sales_document.elements.ValidInvoiceNo;

public final class InvoiceNoValidator implements ConstraintValidator<ValidInvoiceNo, String> {
    @Override
    public boolean isValid(final String invoiceNo, final ConstraintValidatorContext context) {
        if (invoiceNo == null || invoiceNo.trim().isEmpty()) {
            return true;
        }

        return invoiceNo.matches("^[\\p{L}\\p{N}/-]{1,70}$");
    }
}
