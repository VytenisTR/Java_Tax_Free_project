package project.declaration.elements.subelements;

import project.core.DateFormatter;
import java.time.LocalDate;

public final class Person {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;

    public Person(final String firstName, final String lastName,
                  final PersonIdentification personId, final int year, final int month, final int day) {
        this.firstName = (firstName.substring(0, 1).toUpperCase()
                + firstName.substring(1).toLowerCase()).trim();
        this.lastName = ((lastName.substring(0, 1).toUpperCase())
                + lastName.substring(1).toLowerCase()).trim();
        this.birthDate = LocalDate.of(year, month, day);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return DateFormatter.getFormattedDate(birthDate);
    }
}
