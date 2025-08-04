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
    String message() default "{custom.validator.valid-cash-register-no}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
