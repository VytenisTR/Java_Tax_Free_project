package project.common.validation.customer;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.customer.PersonFirstNameValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PersonFirstNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidPersonFirstName {
    String message() default "First name should be at least 1 " +
            "character and no more than 200 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
