package project.declaration.elements.sales_document.nested_dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.common.validation.product.ValidProductMeasurementUnits;
import project.common.validation.product.elements.ValidMeasurementUnitsOther;
import project.common.validation.product.elements.ValidProductDescription;
import project.enums.MeasurementUnits;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@ValidProductMeasurementUnits
public final class ProductDto {
    @NotBlank(message = "{product.product-description-required}")
    @ValidProductDescription
    private String productDescription;
    @NotNull(message = "{product.product-quantity-required}")
    @Min(value = 1, message = "{product.product-quantity-min}")
    private Integer productQuantity;
    private MeasurementUnits measurementUnits;
    @ValidMeasurementUnitsOther
    private String measurementUnitsOther;
    @NotNull(message = "{product.taxable-amount-required}")
    @DecimalMin(value = "0.00", message = "{product.taxable-amount-min}")
    @Digits(integer = 16, fraction = 2, message = "{product.taxable-amount-format}")
    private BigDecimal taxableAmount;
    @NotNull(message = "{product.vat-amount-required}")
    @DecimalMin(value = "0.00", message = "{product.vat-amount-min}")
    @Digits(integer = 16, fraction = 2, message = "{product.vat-amount-format}")
    private BigDecimal vatAmount;
    @NotNull(message = "{product.total-amount-required}")
    @DecimalMin(value = "0.01", message = "{product.total-amount-min}")
    @Digits(integer = 16, fraction = 2, message = "{product.total-amount-format}")
    private BigDecimal totalAmount;
}
