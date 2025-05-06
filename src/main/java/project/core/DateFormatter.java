package project.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateFormatter {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static String getFormattedDate(final LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
}
