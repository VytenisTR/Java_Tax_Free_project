package project.declaration.nested_dto.sales_document.sales_document_dto;

import lombok.*;
import project.common.validation.sales_document.elements.ValidInvoiceNo;
import project.declaration.validation.nested_steps.SalesDocumentStep;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public final class Invoice {
    @ValidInvoiceNo(groups = SalesDocumentStep.class)
    private String invoiceNo;
}