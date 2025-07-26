package project.common.validation.product.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.product.elements.MeasurementUnitsOtherValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MeasurementUnitsOtherValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMeasurementUnitsOther {
    String message() default "Measurement units can be comprised of both letters " +
            "and numbers (with special symbols (only / and -) as well as whitespaces) and " +
            "must be at least 1 character and no more than 50 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
