package project.declaration.nested_dto.customer.customer_dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import project.common.validation.customer.elements.ValidPersonBirthDate;
import project.common.validation.customer.elements.ValidPersonFirstName;
import project.common.validation.customer.elements.ValidPersonLastName;
import project.declaration.validation.nested_steps.CustomerStep;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public final class Person {
    @NotBlank(message = "{person.first-name-required}", groups = CustomerStep.class)
    @ValidPersonFirstName(groups = CustomerStep.class)
    private String firstName;
    @NotBlank(message = "{person.last-name-required}", groups = CustomerStep.class)
    @ValidPersonLastName(groups = CustomerStep.class)
    private String lastName;
    @NotNull(message = "{person.birthdate-required}", groups = CustomerStep.class)
    @ValidPersonBirthDate(groups = CustomerStep.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
}
