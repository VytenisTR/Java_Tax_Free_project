package project.common.validation.product;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.product.ProductDescriptionValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProductDescriptionValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidProductDescription {
    String message() default "Product description should be at least 1 " +
            "character and no more than 500 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
