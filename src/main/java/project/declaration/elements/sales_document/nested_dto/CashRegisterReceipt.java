package project.declaration.elements.sales_document.nested_dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.common.validation.sales_document.elements.ValidCashReceiptNo;
import project.common.validation.sales_document.elements.ValidCashRegisterNo;

@NoArgsConstructor
@Getter
@Setter
public final class CashRegisterReceipt {
    @ValidCashRegisterNo
    private String cashRegisterNo;
    @ValidCashReceiptNo
    private String cashReceiptNo;
}
