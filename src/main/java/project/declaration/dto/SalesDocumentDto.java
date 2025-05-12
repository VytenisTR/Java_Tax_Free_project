package project.declaration.dto;

import project.declaration.elements.sales_document.CashRegisterReceipt;
import project.declaration.elements.sales_document.Invoice;

public final class SalesDocumentDto {
    private CashRegisterReceipt cashRegisterReceipt;
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
