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
    String message() default "{custom.validator.valid-residential-document}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
