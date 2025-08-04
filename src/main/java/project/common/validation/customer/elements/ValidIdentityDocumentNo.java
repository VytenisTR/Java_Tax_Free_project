package project.common.validation.customer.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.customer.elements.IdentityDocumentNoValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdentityDocumentNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidIdentityDocumentNo {
    String message() default "{custom.validator.valid-identity-document-no}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
