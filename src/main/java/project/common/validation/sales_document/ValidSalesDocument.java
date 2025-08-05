package project.common.validation.sales_document;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import project.common.validation.implementation.sales_document.SalesDocumentValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SalesDocumentValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSalesDocument {
    String message() default "{custom.validator.valid-sales-document-default}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
