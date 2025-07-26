package project.common.validation.salesman;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.salesman.VatCodeIssuerValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = VatCodeIssuerValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidVatCodeIssuer {
    String message() default "VAT code issuer must always be Lithuania!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
