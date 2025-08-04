package project.common.validation.product;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.product.ProductMeasurementUnitsValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProductMeasurementUnitsValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidProductMeasurementUnits {
    String message() default "{custom.validator.valid-product-measurement-units}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
