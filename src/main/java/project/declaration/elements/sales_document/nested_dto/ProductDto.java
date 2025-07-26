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
    @NotBlank(message = "Product description is required.")
    @ValidProductDescription
    private String productDescription;
    @NotNull(message = "Product quantity is required.")
    @Min(value = 1, message = "Product quantity must be greater than 0!")
    private Integer productQuantity;
    private MeasurementUnits measurementUnits;
    @ValidMeasurementUnitsOther
    private String measurementUnitsOther;
    @NotNull(message = "Taxable amount is required.")
    @DecimalMin(value = "0.00", message = "Taxable amount must be a decimal greater or equal to 0!")
    @Digits(integer = 16, fraction = 2, message = "Taxable amount must be in a correct format - " +
            "decimal greater or equal to 0, containing 2 digits separated by a comma!")
    private BigDecimal taxableAmount;
    @NotNull(message = "VAT amount is required.")
    @DecimalMin(value = "0.00", message = "VAT amount must be a decimal greater or equal to 0!")
    @Digits(integer = 16, fraction = 2, message = "VAT amount must be in a correct format - " +
            "decimal greater or equal to 0, containing 2 digits separated by a comma!")
    private BigDecimal vatAmount;
    @NotNull(message = "Total amount is required.")
    @DecimalMin(value = "0.01", message = "Total amount must be a decimal greater than 0!")
    @Digits(integer = 16, fraction = 2, message = "Total amount must be in a correct format - " +
            "decimal greater than 0, containing 2 digits separated by a comma!")
    private BigDecimal totalAmount;
}
