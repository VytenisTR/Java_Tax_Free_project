package project.declaration.model.elements_model.sales_document.nested_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Invoice {
    @Column(name = "invoice_no")
    private String invoiceNo;
}
