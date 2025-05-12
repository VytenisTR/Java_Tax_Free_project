package project.declaration.elements.sales_document;

import project.core.DateFormatter;
import java.time.LocalDate;

public final class Invoice {
    private final long invoiceNo;
    private final LocalDate salesDate;

    public Invoice(long invoiceNo, int year, int month, int day) {
        this.invoiceNo = invoiceNo;
        this.salesDate = LocalDate.of(year, month, day);
    }

    public long getInvoiceNo() {
        return invoiceNo;
    }

    public String getSalesDate() {
        return DateFormatter.getFormattedDate(salesDate);
    }
}
