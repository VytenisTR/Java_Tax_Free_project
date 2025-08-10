package project.common.validation.implementation.product.nested_product;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.product.elements.ValidMeasurementUnitsOther;

public final class MeasurementUnitsOtherValidator implements ConstraintValidator<ValidMeasurementUnitsOther, String> {
    @Override
    public boolean isValid(final String measurementUnitsOther, final ConstraintValidatorContext context) {
        if (measurementUnitsOther == null || measurementUnitsOther.trim().isEmpty()) {
            return true;
        }

        return measurementUnitsOther.matches("^[\\p{L}\\p{N}/\\- ]{1,50}$");
    }
}
