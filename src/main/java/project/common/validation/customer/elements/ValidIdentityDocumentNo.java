package project.common.validation.customer.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.customer.elements.IdentityDocumentNoValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdentityDocumentNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidIdentityDocumentNo {
    String message() default "Identity document number can be comprised of both letters " +
            "and numbers (with the special symbols (only / and -), but no whitespaces) and " +
            "must be at least 1 character and no more than 50 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
