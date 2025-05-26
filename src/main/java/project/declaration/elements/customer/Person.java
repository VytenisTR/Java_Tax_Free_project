package project.declaration.elements.customer;

import project.common.validation.customer.ValidPersonBirthDate;
import project.common.validation.customer.ValidPersonFirstName;
import project.common.validation.customer.ValidPersonLastName;
import project.core.DateFormatter;
import java.time.LocalDate;

public final class Person {
    @ValidPersonFirstName
    private final String firstName;
    @ValidPersonLastName
    private final String lastName;
    @ValidPersonBirthDate
    private final LocalDate birthDate;

    public Person(final String firstName, final String lastName,
                  final int year, final int month, final int day) {
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
