package project.declaration.elements.customer.nested_dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import project.common.validation.customer.elements.ValidPersonBirthDate;
import project.common.validation.customer.elements.ValidPersonFirstName;
import project.common.validation.customer.elements.ValidPersonLastName;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public final class Person {
    @NotBlank(message = "First name is required.")
    @ValidPersonFirstName
    private String firstName;
    @NotBlank(message = "Last name is required.")
    @ValidPersonLastName
    private String lastName;
    @NotNull(message = "Birth date is required.")
    @ValidPersonBirthDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
}
