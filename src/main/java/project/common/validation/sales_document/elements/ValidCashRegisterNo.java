package project.common.validation.sales_document.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.sales_document.elements.CashRegisterNoValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CashRegisterNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCashRegisterNo {
    String message() default "Cash register number can be comprised of both letters " +
            "and numbers (with the special symbols (only / and -), but no whitespaces) and " +
            "must be at least 1 character and no more than 50 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
