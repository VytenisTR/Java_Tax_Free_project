package project.common.validation.customer.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.customer.elements.PersonFirstNameValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PersonFirstNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPersonalIdNo {
    String message() default "{custom.validator.valid-personal-id-no}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
