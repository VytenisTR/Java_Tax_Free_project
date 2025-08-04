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
    String message() default "{custom.validator.valid-vat-payer-code}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
