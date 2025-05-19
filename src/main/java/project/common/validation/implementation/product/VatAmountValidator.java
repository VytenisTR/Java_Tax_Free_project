package project.common.validation.implementation.product;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.product.ValidVatAmount;

public final class VatAmountValidator implements ConstraintValidator<ValidVatAmount, Double> {
    @Override
    public boolean isValid(final Double vatAmount, final ConstraintValidatorContext context) {
        return (vatAmount > 0 && vatAmount.toString().length() <= 19);
    }
}
