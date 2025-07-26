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
    String message() default "Last name must use Lithuanian characters " +
            "(without the special symbols or whitespaces) " +
            "and must be at least 1 character and no more than 200 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
