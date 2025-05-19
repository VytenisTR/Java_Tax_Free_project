package project.common.validation.sales_document;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.sales_document.InvoiceNoValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InvoiceNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidInvoiceNo {
    String message() default "Invoice number should be at least 1 " +
            "character and no more than 70 characters in length!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
