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
    String message() default "{custom.validator.valid-cash-receipt-no}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
