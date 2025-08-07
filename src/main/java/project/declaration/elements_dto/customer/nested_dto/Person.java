package project.declaration.elements_dto.customer.nested_dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import project.common.validation.customer.elements.ValidPersonBirthDate;
import project.common.validation.customer.elements.ValidPersonFirstName;
import project.common.validation.customer.elements.ValidPersonLastName;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public final class Person {
    @NotBlank(message = "{person.first-name-required}")
    @ValidPersonFirstName
    private String firstName;
    @NotBlank(message = "{person.last-name-required}")
    @ValidPersonLastName
    private String lastName;
    @NotNull(message = "{person.birthdate-required}")
    @ValidPersonBirthDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
}
