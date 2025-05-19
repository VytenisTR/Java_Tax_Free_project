package project.common.validation.product;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.product.MeasurementUnitsOtherValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MeasurementUnitsOtherValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidMeasurementUnitsOther {
    String message() default "Measurement units should be at least 1 " +
            "character and no more than 50 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
