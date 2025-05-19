package project.common.validation.implementation.product;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.product.ValidTotalAmount;

public final class TotalAmountValidator implements ConstraintValidator<ValidTotalAmount, Double> {
    @Override
    public boolean isValid(final Double totalAmount, final ConstraintValidatorContext context) {
        return (totalAmount > 0 && totalAmount.toString().length() <= 19);
    }
}
