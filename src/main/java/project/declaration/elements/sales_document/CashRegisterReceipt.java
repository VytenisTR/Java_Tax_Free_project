package project.declaration.elements.sales_document;

public final class CashRegisterReceipt {
    private final long cashRegisterNo;
    private final long cashReceiptNo;

    public CashRegisterReceipt(final long cashRegisterNo, final long cashReceiptNo) {
        this.cashRegisterNo = cashRegisterNo;
        this.cashReceiptNo = cashReceiptNo;
    }

    public long getCashRegisterNo() {
        return cashRegisterNo;
    }

    public long getCashReceiptNo() {
        return cashReceiptNo;
    }
}
