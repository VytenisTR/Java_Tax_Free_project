package project.common.validation.implementation.product.nested_product;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.product.elements.ValidProductDescription;

public final class ProductDescriptionValidator implements ConstraintValidator<ValidProductDescription, String> {
    @Override
    public boolean isValid(final String productDescription, final ConstraintValidatorContext context) {
        if (productDescription == null || productDescription.trim().isEmpty()) {
            return true;
        }

        return productDescription.matches("^[\\p{L}\\p{N}/\\- ]{1,500}$");
    }
}
