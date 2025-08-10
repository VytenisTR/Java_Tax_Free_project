package project.common.validation.customer.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.customer.nested_customer.PersonFirstNameValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PersonFirstNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPersonFirstName {
    String message() default "{custom.validator.valid-person-first-name}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
