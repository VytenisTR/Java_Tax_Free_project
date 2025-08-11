package project.common.validation.implementation.product;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import project.common.validation.product.ValidProductMeasurementUnits;
import project.declaration.nested_dto.sales_document.sales_document_dto.ProductDto;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public final class ProductMeasurementUnitsValidator implements ConstraintValidator<ValidProductMeasurementUnits,
        ProductDto> {

    private final MessageSource messageSource;

    @Override
    public boolean isValid(final ProductDto productDto,
                           final ConstraintValidatorContext context) {
        if (productDto == null) {
            return true;
        }

        boolean measurementUnitsExists = productDto.getMeasurementUnits() != null;
        boolean measurementUnitsOtherExists = productDto.getMeasurementUnitsOther() != null &&
                !productDto.getMeasurementUnitsOther().trim().isEmpty();

        boolean productMeasurementUnitsValid = true;

        Locale currentLocale = LocaleContextHolder.getLocale();

        context.disableDefaultConstraintViolation();

        if (measurementUnitsExists && measurementUnitsOtherExists) {
            String localizedMessage = messageSource.getMessage(
                    "custom.validator.valid-product-measurement-units-only",
                    null,
                    currentLocale
            );

            context.buildConstraintViolationWithTemplate(localizedMessage)
                    .addPropertyNode("measurementUnits")
                    .addConstraintViolation();
            productMeasurementUnitsValid = false;
        }

        if (!measurementUnitsExists && !measurementUnitsOtherExists) {
            String localizedMessage = messageSource.getMessage(
                    "custom.validator.valid-product-measurement-units-either",
                    null,
                    currentLocale
            );

            context.buildConstraintViolationWithTemplate(localizedMessage)
                    .addPropertyNode("measurementUnits")
                    .addConstraintViolation();
            productMeasurementUnitsValid = false;
        }

        return productMeasurementUnitsValid;
    }
}
