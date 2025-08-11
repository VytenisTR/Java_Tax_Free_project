package project.common.validation.implementation.sales_document;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import project.common.validation.sales_document.ValidSalesDocument;
import project.declaration.nested_dto.sales_document.SalesDocumentDto;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public final class SalesDocumentValidator implements ConstraintValidator<ValidSalesDocument,
        SalesDocumentDto> {

    private final MessageSource messageSource;

    @Override
    public boolean isValid(final SalesDocumentDto salesDocumentDto,
                           final ConstraintValidatorContext context) {
        if (salesDocumentDto == null) {
            return true;
        }

        boolean cashRegisterReceiptExists = salesDocumentDto.getCashRegisterReceipt() != null &&
                salesDocumentDto.getCashRegisterReceipt().getCashRegisterNo() != null &&
                !salesDocumentDto.getCashRegisterReceipt().getCashRegisterNo().trim().isEmpty() &&
                salesDocumentDto.getCashRegisterReceipt().getCashReceiptNo() != null &&
                !salesDocumentDto.getCashRegisterReceipt().getCashReceiptNo().trim().isEmpty();
        boolean invoiceExists = salesDocumentDto.getInvoice() != null &&
                salesDocumentDto.getInvoice().getInvoiceNo() != null &&
                !salesDocumentDto.getInvoice().getInvoiceNo().trim().isEmpty();
        boolean salesDateExists = salesDocumentDto.getSalesDate() != null;

        boolean salesDocumentValid = true;

        Locale currentLocale = LocaleContextHolder.getLocale();

        context.disableDefaultConstraintViolation();

        if (!cashRegisterReceiptExists && !invoiceExists) {
            String localizedMessage = messageSource.getMessage(
                    "custom.validator.valid-sales-document-cash-register-invoice-either",
                    null,
                    currentLocale
            );

            context.buildConstraintViolationWithTemplate(localizedMessage)
                    .addConstraintViolation();
            salesDocumentValid = false;
        }

        if (cashRegisterReceiptExists && invoiceExists) {
            String localizedMessage = messageSource.getMessage(
                    "custom.validator.valid-sales-document-cash-register-invoice-only",
                    null,
                    currentLocale
            );

            context.buildConstraintViolationWithTemplate(localizedMessage)
                    .addConstraintViolation();
            salesDocumentValid = false;
        }

        if ((cashRegisterReceiptExists || invoiceExists) && !salesDateExists) {
            String localizedMessage = messageSource.getMessage(
                    "custom.validator.valid-sales-document-sales-date",
                    null,
                    currentLocale
            );

            context.buildConstraintViolationWithTemplate(localizedMessage)
                    .addPropertyNode("salesDate")
                    .addConstraintViolation();
            salesDocumentValid = false;
        }

        return salesDocumentValid;
    }
}
