package project.common.validation.customer;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.customer.ResidentialDocumentNoValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ResidentialDocumentNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidResidentialDocumentNo {
    String message() default "Document number should be at least 1 " +
            "character and no more than 50 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
