package project.core;

public final class DeclarationConstants {
    private static long PRODUCT_SEQUENCE_NUMBER = 1;
    private static final double VAT_RATE = 0.21;

    public static double getVatRate() {
        return VAT_RATE;
    }

    public static long getProductSequenceNumber() {
        return PRODUCT_SEQUENCE_NUMBER;
    }

    public static void setProductSequenceNumber(final long productSequenceNumber) {
        PRODUCT_SEQUENCE_NUMBER = productSequenceNumber;
    }

    public static void incrementProductSequenceNumber() {
        PRODUCT_SEQUENCE_NUMBER++;
    }
}
