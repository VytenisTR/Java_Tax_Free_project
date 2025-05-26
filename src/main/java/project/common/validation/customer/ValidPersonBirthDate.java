package project.common.validation.customer;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.customer.PersonBirthDateValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PersonBirthDateValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidPersonBirthDate {
    String message() default "Birthdate cannot be before 1920-01-01 or in the future!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
