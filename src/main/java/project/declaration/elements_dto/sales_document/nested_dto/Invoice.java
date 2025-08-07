package project.declaration.elements_dto.sales_document.nested_dto;

import lombok.*;
import project.common.validation.sales_document.elements.ValidInvoiceNo;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public final class Invoice {
    @ValidInvoiceNo
    private String invoiceNo;
}
