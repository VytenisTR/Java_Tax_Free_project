package project.common.validation.implementation.sales_document;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.sales_document.ValidSalesDate;
import project.core.DeclarationConstants;

import java.time.LocalDate;

public final class SalesDateValidator implements ConstraintValidator<ValidSalesDate, LocalDate> {
    @Override
    public boolean isValid(final LocalDate salesDate, final ConstraintValidatorContext context) {
        return !salesDate.isAfter(DeclarationConstants.getMaxDate());
    }
}
