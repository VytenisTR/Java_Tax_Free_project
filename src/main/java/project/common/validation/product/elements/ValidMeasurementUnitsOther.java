package project.common.validation.product.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.product.nested_product.MeasurementUnitsOtherValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MeasurementUnitsOtherValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMeasurementUnitsOther {
    String message() default "{custom.validator.valid-product-measurement-units-other}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
