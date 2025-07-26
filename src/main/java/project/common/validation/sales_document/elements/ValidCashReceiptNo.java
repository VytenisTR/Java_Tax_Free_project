package project.common.validation.sales_document.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.sales_document.elements.CashReceiptNoValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CashReceiptNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCashReceiptNo {
    String message() default "Cash receipt number can be comprised of both letters " +
            "and numbers (with the special symbols (only / and -), but no whitespaces) and " +
            "must be at least 1 character and no more than 70 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
