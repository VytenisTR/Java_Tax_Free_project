package project.common.validation.product;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.product.VatAmountValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = VatAmountValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidVatAmount {
    String message() default "Vat amount value must be a decimal greater than 0, " +
            "which does not exceed 9999999999999999.99!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
