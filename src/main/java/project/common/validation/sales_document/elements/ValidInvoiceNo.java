package project.common.validation.sales_document.elements;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.sales_document.elements.InvoiceNoValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InvoiceNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInvoiceNo {
    String message() default "{custom.validator.valid-invoice-no}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
