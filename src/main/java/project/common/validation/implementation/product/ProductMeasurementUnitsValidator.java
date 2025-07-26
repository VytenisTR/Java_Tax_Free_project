package project.common.validation.implementation.product;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import project.common.validation.product.ValidProductMeasurementUnits;
import project.declaration.elements.sales_document.nested_dto.ProductDto;

public final class ProductMeasurementUnitsValidator implements ConstraintValidator<ValidProductMeasurementUnits,
        ProductDto> {
    @Override
    public boolean isValid(final ProductDto productDto,
                           final ConstraintValidatorContext context) {
        if (productDto == null) {
            return true;
        }

        final boolean measurementUnitsExists = productDto.getMeasurementUnits() != null;
        final boolean measurementUnitsOtherExists = productDto.getMeasurementUnitsOther() != null &&
                !productDto.getMeasurementUnitsOther().trim().isEmpty();

        boolean productMeasurementUnitsValid = true;

        context.disableDefaultConstraintViolation();

        if (measurementUnitsExists && measurementUnitsOtherExists) {
            context.buildConstraintViolationWithTemplate("Only one of the product unit measurement fields " +
                            "should be filled in!")
                    .addPropertyNode("measurementUnits")
                    .addConstraintViolation();
            productMeasurementUnitsValid = false;
        }

        if (!measurementUnitsExists && !measurementUnitsOtherExists) {
            context.buildConstraintViolationWithTemplate("Only one of the product unit measurement fields " +
                            "is required to be filled in!")
                    .addPropertyNode("measurementUnits")
                    .addConstraintViolation();
            productMeasurementUnitsValid = false;
        }

        return productMeasurementUnitsValid;
    }
}
