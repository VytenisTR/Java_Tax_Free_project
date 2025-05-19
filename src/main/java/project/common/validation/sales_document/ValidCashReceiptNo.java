package project.common.validation.sales_document;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.sales_document.CashReceiptNoValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CashReceiptNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidCashReceiptNo {
    String message() default "Cash receipt number should be at least 1 " +
            "character and no more than 70 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
