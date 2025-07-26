package project.common.validation.implementation.salesman;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.salesman.ValidSalesmanName;

public final class SalesmanNameValidator implements ConstraintValidator<ValidSalesmanName, String> {
    @Override
    public boolean isValid(final String salesmanName, final ConstraintValidatorContext context) {
        if (salesmanName == null || salesmanName.trim().isEmpty()) {
            return true;
        }

        return salesmanName.matches("^[\\p{L}\\p{N} ]{1,300}$");
    }
}
