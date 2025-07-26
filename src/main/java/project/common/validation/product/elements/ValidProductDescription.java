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
    String message() default "Product description can be comprised of both letters " +
            "and numbers (with the special symbols (only / and -) as well as whitespaces) and " +
            "must be at least 1 character and no more than 500 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
