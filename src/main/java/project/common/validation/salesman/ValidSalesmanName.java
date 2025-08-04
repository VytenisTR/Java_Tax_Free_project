package project.common.validation.salesman;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.salesman.SalesmanNameValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SalesmanNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSalesmanName {
    String message() default "{custom.validator.valid-salesman-name}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
