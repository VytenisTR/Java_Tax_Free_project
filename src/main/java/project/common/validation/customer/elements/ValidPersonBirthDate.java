package project.common.validation.customer.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.customer.elements.PersonBirthDateValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PersonBirthDateValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPersonBirthDate {
    String message() default "Birthdate must be after 1920-01-01 " +
            "and before today's date excluding 18 years!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
