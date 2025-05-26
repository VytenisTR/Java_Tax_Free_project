package project.common.validation.salesman;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.salesman.SalesmanNameValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SalesmanNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidSalesmanName {
    String message() default "Salesman name should be at least 1 " +
            "character and no more than 300 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
