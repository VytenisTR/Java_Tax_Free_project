package project.declaration.dto;

import jakarta.validation.Valid;
import project.declaration.elements.sales_document.CashRegisterReceipt;
import project.declaration.elements.sales_document.Invoice;

public final class SalesDocumentDto {
    @Valid
    private CashRegisterReceipt cashRegisterReceipt;
    @Valid
    private Invoice invoice;

    public SalesDocumentDto(final CashRegisterReceipt cashRegisterReceipt) {
        this.cashRegisterReceipt = cashRegisterReceipt;
    }

    public SalesDocumentDto(final Invoice invoice) {
        this.invoice = invoice;
    }

    public CashRegisterReceipt getCashRegisterReceipt() {
        return cashRegisterReceipt;
    }

    public Invoice getInvoice() {
        return invoice;
    }
}
