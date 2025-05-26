package project.common.validation.intermediary;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.intermediary.IntermediaryIdNoValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IntermediaryIdNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidIntermediaryIdNo {
    String message() default "Intermediary identification number should be from 6 to 10 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
