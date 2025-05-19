package project.declaration.elements.sales_document;

import project.common.validation.sales_document.ValidCashReceiptNo;
import project.common.validation.sales_document.ValidCashRegisterNo;
import project.common.validation.sales_document.ValidSalesDate;
import project.core.DateFormatter;
import java.time.LocalDate;

public final class CashRegisterReceipt {
    @ValidCashRegisterNo
    private final String cashRegisterNo;
    @ValidCashReceiptNo
    private final String cashReceiptNo;
    @ValidSalesDate
    private final LocalDate salesDate;

    public CashRegisterReceipt(final String cashRegisterNo, final String cashReceiptNo,
                               final int year, final int month, final int day) {
        this.cashRegisterNo = cashRegisterNo;
        this.cashReceiptNo = cashReceiptNo;
        this.salesDate = LocalDate.of(year, month, day);
    }

    public String getCashRegisterNo() {
        return cashRegisterNo;
    }

    public String getCashReceiptNo() {
        return cashReceiptNo;
    }

    public String getSalesDate() {
        return DateFormatter.getFormattedDate(salesDate);
    }
}
