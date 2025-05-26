package project.core;

import java.time.LocalDate;

public final class DeclarationConstants {
    private static long PRODUCT_SEQUENCE_NUMBER = 1;
    private static final double VAT_RATE = 0.21;
    private static final LocalDate MIN_BIRTH_DATE = LocalDate.of(1920, 1, 1);
    private static final LocalDate MAX_DATE = LocalDate.now();

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

    public static LocalDate getMinBirthDate() {
        return MIN_BIRTH_DATE;
    }

    public static LocalDate getMaxDate() {
        return MAX_DATE;
    }
}
