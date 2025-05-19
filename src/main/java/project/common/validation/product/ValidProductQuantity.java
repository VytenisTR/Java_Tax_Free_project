package project.common.validation.product;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.product.ProductQuantityValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProductQuantityValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidProductQuantity {
    String message() default "Product quantity value must be an integer greater than 0!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
