package project.common.validation.implementation.product;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.product.ValidProductDescription;

public final class ProductDescriptionValidator implements ConstraintValidator<ValidProductDescription, String> {
    @Override
    public boolean isValid(final String productDescription, final ConstraintValidatorContext context) {
        return (!productDescription.trim().isEmpty() && productDescription.trim().length() <= 500);
    }
}
