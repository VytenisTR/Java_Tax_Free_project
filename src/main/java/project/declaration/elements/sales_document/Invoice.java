package project.declaration.elements.sales_document;

import project.common.validation.sales_document.ValidInvoiceNo;
import project.common.validation.sales_document.ValidSalesDate;
import project.core.DateFormatter;
import java.time.LocalDate;

public final class Invoice {
    @ValidInvoiceNo
    private final String invoiceNo;
    @ValidSalesDate
    private final LocalDate salesDate;

    public Invoice(final String invoiceNo, final int year, final int month, final int day) {
        this.invoiceNo = invoiceNo;
        this.salesDate = LocalDate.of(year, month, day);
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public String getSalesDate() {
        return DateFormatter.getFormattedDate(salesDate);
    }
}
