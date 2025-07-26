package project.declaration.elements.sales_document.nested_dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.common.validation.sales_document.elements.ValidInvoiceNo;

@NoArgsConstructor
@Getter
@Setter
public final class Invoice {
    @ValidInvoiceNo
    private String invoiceNo;
}
