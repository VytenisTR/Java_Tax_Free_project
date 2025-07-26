package project.common.validation.customer;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.customer.PersonIdentificationValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PersonIdentificationValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPersonIdentification {
    String message() default "ID issuer is required when the personal identification number (ID) is provided!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
