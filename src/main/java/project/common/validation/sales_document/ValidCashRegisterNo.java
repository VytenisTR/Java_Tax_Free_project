package project.common.validation.sales_document;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.sales_document.CashRegisterNoValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CashRegisterNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidCashRegisterNo {
    String message() default "Cash register number should be at least 1 " +
            "character and no more than 50 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
