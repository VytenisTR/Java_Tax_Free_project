package project.common.validation.intermediary;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.intermediary.IntermediaryValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IntermediaryValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidIntermediary {
    String message() default "Intermediary information must be filled in!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
