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
    String message() default "{custom.validator.valid-person-birthdate-default}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
