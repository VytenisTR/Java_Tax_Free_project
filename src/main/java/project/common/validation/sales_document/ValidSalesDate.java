package project.common.validation.sales_document;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import project.common.validation.implementation.sales_document.SalesDateValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SalesDateValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ValidSalesDate {
    String message() default "Sales date cannot be past 2100-01-01!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
