package project.common.validation.customer.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.customer.elements.PersonLastNameValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PersonLastNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPersonLastName {
    String message() default "{custom.validator.valid-person-last-name}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
