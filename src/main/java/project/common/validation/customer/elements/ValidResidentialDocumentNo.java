package project.common.validation.customer.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.customer.elements.ResidentialDocumentNoValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ResidentialDocumentNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidResidentialDocumentNo {
    String message() default "{custom.validator.valid-residential-document-no-default}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
