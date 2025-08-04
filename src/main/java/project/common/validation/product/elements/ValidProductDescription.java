package project.common.validation.product.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.product.elements.ProductDescriptionValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProductDescriptionValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidProductDescription {
    String message() default "{custom.validator.valid-product-description}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
