package project.common.validation.salesman;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.salesman.VatPayerCodeValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = VatPayerCodeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidVatPayerCode {
    String message() default "VAT payer code should be in the following format: " +
            "'LT' + 9 or 12 digits after it!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
