package project.declaration.nested_dto.sales_document.sales_document_dto;

import lombok.*;
import project.common.validation.sales_document.elements.ValidCashReceiptNo;
import project.common.validation.sales_document.elements.ValidCashRegisterNo;
import project.declaration.validation.nested_steps.SalesDocumentStep;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public final class CashRegisterReceipt {
    @ValidCashRegisterNo(groups = SalesDocumentStep.class)
    private String cashRegisterNo;
    @ValidCashReceiptNo(groups = SalesDocumentStep.class)
    private String cashReceiptNo;
}
