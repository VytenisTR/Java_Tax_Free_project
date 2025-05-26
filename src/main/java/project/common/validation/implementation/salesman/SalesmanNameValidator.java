package project.common.validation.implementation.salesman;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.salesman.ValidSalesmanName;

public final class SalesmanNameValidator implements ConstraintValidator<ValidSalesmanName, String> {
    @Override
    public boolean isValid(final String salesmanName, final ConstraintValidatorContext context) {
        return (!salesmanName.trim().isEmpty() && salesmanName.trim().length() <= 300);
    }
}
