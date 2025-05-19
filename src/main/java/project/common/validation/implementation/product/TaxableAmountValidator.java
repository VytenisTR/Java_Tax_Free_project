package project.common.validation.implementation.product;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.product.ValidTaxableAmount;

public final class TaxableAmountValidator implements ConstraintValidator<ValidTaxableAmount, Double> {
    @Override
    public boolean isValid(final Double taxableAmount, final ConstraintValidatorContext context) {
        return (taxableAmount > 0 && taxableAmount.toString().length() <= 19);
    }
}
