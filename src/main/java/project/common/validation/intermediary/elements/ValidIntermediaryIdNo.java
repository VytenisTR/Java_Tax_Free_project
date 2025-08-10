package project.common.validation.intermediary.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.intermediary.nested_intermediary.IntermediaryIdNoValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IntermediaryIdNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidIntermediaryIdNo {
    String message() default "{custom.validator.valid-intermediary-id-no-default}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
