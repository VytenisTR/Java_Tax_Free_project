package project.core;

import java.time.LocalDate;

public final class DeclarationConstants {
    private static final LocalDate MIN_BIRTH_DATE =
            LocalDate.parse(DateFormatter.getFormattedDate(LocalDate.of(1920, 1, 1)));
    private static final LocalDate MAX_BIRTH_DATE =
            LocalDate.parse(DateFormatter.getFormattedDate(LocalDate.now().minusYears(18)));
    private static final LocalDate MAX_SALES_DATE =
            LocalDate.parse(DateFormatter.getFormattedDate(LocalDate.now()));
    private static final Double VAT_RATE = 0.21;

    public static LocalDate getMinBirthDate() {
        return MIN_BIRTH_DATE;
    }

    public static LocalDate getMaxBirthDate() {
        return MAX_BIRTH_DATE;
    }

    public static LocalDate getMaxSalesDate() {
        return MAX_SALES_DATE;
    }
}
