package project.common.validation.salesman;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.salesman.VatPayerCodeValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = VatPayerCodeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidVatPayerCode {
    String message() default "VAT payer code should be 9 or 12 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
