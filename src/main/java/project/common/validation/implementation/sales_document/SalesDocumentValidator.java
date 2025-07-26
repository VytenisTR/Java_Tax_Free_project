package project.common.validation.implementation.sales_document;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.sales_document.ValidSalesDocument;
import project.declaration.elements.sales_document.SalesDocumentDto;

public final class SalesDocumentValidator implements ConstraintValidator<ValidSalesDocument,
        SalesDocumentDto> {
    @Override
    public boolean isValid(final SalesDocumentDto salesDocumentDto,
                           final ConstraintValidatorContext context) {
        if (salesDocumentDto == null) {
            return true;
        }

        final boolean cashRegisterReceiptExists = salesDocumentDto.getCashRegisterReceipt() != null &&
                salesDocumentDto.getCashRegisterReceipt().getCashRegisterNo() != null &&
                !salesDocumentDto.getCashRegisterReceipt().getCashRegisterNo().trim().isEmpty() &&
                salesDocumentDto.getCashRegisterReceipt().getCashReceiptNo() != null &&
                !salesDocumentDto.getCashRegisterReceipt().getCashReceiptNo().trim().isEmpty();
        final boolean invoiceExists = salesDocumentDto.getInvoice() != null &&
                salesDocumentDto.getInvoice().getInvoiceNo() != null &&
                !salesDocumentDto.getInvoice().getInvoiceNo().trim().isEmpty();
        final boolean salesDateExists = salesDocumentDto.getSalesDate() != null;

        boolean salesDocumentValid = true;

        context.disableDefaultConstraintViolation();

        if (!cashRegisterReceiptExists && !invoiceExists) {
            context.buildConstraintViolationWithTemplate("Either fields for the cash register receipt " +
                            "or fields for the invoice must be filled in!")
                    .addConstraintViolation();
            salesDocumentValid = false;
        }

        if (cashRegisterReceiptExists && invoiceExists) {
            context.buildConstraintViolationWithTemplate("Only fields for the cash register receipt " +
                            "or fields for the invoice may be filled in!")
                    .addConstraintViolation();
            salesDocumentValid = false;
        }

        if ((cashRegisterReceiptExists || invoiceExists) && !salesDateExists) {
            context.buildConstraintViolationWithTemplate("Sales date must be filled in!")
                    .addPropertyNode("salesDate")
                    .addConstraintViolation();
            salesDocumentValid = false;
        }

        return salesDocumentValid;
    }
}
