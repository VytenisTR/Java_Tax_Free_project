package project.common.validation.intermediary.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.intermediary.elements.IntermediaryIdNoValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IntermediaryIdNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidIntermediaryIdNo {
    String message() default "Intermediary identification number can be comprised of both letters " +
            "and numbers (with the special symbols (only / and -), but no whitespaces) and " +
            "must be at least 6 characters and no more than 10 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
