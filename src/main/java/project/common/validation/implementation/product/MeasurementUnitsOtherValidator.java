package project.common.validation.implementation.product;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.product.ValidMeasurementUnitsOther;

public final class MeasurementUnitsOtherValidator implements ConstraintValidator<ValidMeasurementUnitsOther, String> {
    @Override
    public boolean isValid(final String measurementUnitsOther, final ConstraintValidatorContext context) {
        return (!measurementUnitsOther.trim().isEmpty() && measurementUnitsOther.trim().length() <= 50);
    }
}
