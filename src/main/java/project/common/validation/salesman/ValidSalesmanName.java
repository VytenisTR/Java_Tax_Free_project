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
    String message() default "Salesman name can be comprised of both letters " +
            "and numbers (without the special symbols, but whitespaces are allowed) and " +
            "must be at least 1 character and no more than 300 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
