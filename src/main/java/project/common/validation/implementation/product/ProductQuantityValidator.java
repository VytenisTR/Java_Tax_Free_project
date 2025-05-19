package project.common.validation.implementation.product;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.product.ValidProductQuantity;

public final class ProductQuantityValidator implements ConstraintValidator<ValidProductQuantity, Long> {
    @Override
    public boolean isValid(final Long productQuantity, final ConstraintValidatorContext context) {
        return productQuantity > 0;
    }
}
