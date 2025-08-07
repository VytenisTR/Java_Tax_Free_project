package project.declaration.elements_dto.sales_document.nested_dto;

import lombok.*;
import project.common.validation.sales_document.elements.ValidCashReceiptNo;
import project.common.validation.sales_document.elements.ValidCashRegisterNo;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public final class CashRegisterReceipt {
    @ValidCashRegisterNo
    private String cashRegisterNo;
    @ValidCashReceiptNo
    private String cashReceiptNo;
}
