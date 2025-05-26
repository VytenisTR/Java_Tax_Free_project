package project.common.validation.intermediary;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.intermediary.IntermediaryNameValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IntermediaryNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidIntermediaryName {
    String message() default "Intermediary name should be at least 1 " +
            "character and no more than 300 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
