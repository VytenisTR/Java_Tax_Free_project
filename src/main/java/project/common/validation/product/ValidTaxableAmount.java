package project.common.validation.product;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.product.TaxableAmountValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TaxableAmountValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidTaxableAmount {
    String message() default "Taxable amount value must be a decimal greater than 0, " +
            "and cannot exceed 9999999999999999.99!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
