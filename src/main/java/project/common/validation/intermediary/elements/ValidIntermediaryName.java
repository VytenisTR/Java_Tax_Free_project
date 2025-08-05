package project.common.validation.intermediary.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.intermediary.elements.IntermediaryNameValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IntermediaryNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidIntermediaryName {
    String message() default "{custom.validator.valid-intermediary-name-default}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
