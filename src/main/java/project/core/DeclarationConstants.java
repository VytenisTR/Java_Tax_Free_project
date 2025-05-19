package project.core;

import java.time.LocalDate;

public final class DeclarationConstants {
    private static long PRODUCT_SEQUENCE_NUMBER = 1;
    private static final double VAT_RATE = 0.21;
    private static final LocalDate MAX_DATE = LocalDate.of(2100, 1, 1);

    public static double getVatRate() {
        return VAT_RATE;
    }

    public static long getProductSequenceNumber() {
        return PRODUCT_SEQUENCE_NUMBER;
    }

    public static void setDefaultProductSequenceNumber() {
        PRODUCT_SEQUENCE_NUMBER = 1;
    }

    public static void incrementProductSequenceNumber() {
        PRODUCT_SEQUENCE_NUMBER++;
    }

    public static LocalDate getMaxDate() {
        return MAX_DATE;
    }
}
