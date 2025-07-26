package project.common.validation.customer;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.customer.ResidentialDocumentValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ResidentialDocumentValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidResidentialDocument {
    String message() default "If at least one the fields for other document is filled in, " +
            "the remaining fields for other document must also be filled in!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
