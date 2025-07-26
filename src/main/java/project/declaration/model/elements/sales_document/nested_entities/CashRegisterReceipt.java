package project.declaration.model.elements.sales_document.nested_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CashRegisterReceipt {
    @Column(name = "cash_register_no")
    private String cashRegisterNo;

    @Column(name = "cash_receipt_no")
    private String cashReceiptNo;
}
