package project.declaration.nested_dto.sales_document.sales_document_dto;

import jakarta.validation.constraints.*;
import lombok.*;
import project.common.validation.product.ValidProductMeasurementUnits;
import project.common.validation.product.elements.ValidMeasurementUnitsOther;
import project.common.validation.product.elements.ValidProductDescription;
import project.declaration.validation.nested_steps.SalesDocumentStep;
import project.enums.MeasurementUnits;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ValidProductMeasurementUnits(groups = SalesDocumentStep.class)
public final class ProductDto {
    @NotBlank(message = "{product.product-description-required}", groups = SalesDocumentStep.class)
    @ValidProductDescription(groups = SalesDocumentStep.class)
    private String productDescription;
    @NotNull(message = "{product.product-quantity-required}", groups = SalesDocumentStep.class)
    @Min(value = 1, message = "{product.product-quantity-min}", groups = SalesDocumentStep.class)
    private Integer productQuantity;
    private MeasurementUnits measurementUnits;
    @ValidMeasurementUnitsOther(groups = SalesDocumentStep.class)
    private String measurementUnitsOther;
    @NotNull(message = "{product.taxable-amount-required}", groups = SalesDocumentStep.class)
    @DecimalMin(value = "0.00", message = "{product.taxable-amount-min}", groups = SalesDocumentStep.class)
    @Digits(integer = 16, fraction = 2, message = "{product.taxable-amount-format}", groups = SalesDocumentStep.class)
    private BigDecimal taxableAmount;
    @NotNull(message = "{product.vat-amount-required}", groups = SalesDocumentStep.class)
    @DecimalMin(value = "0.00", message = "{product.vat-amount-min}", groups = SalesDocumentStep.class)
    @Digits(integer = 16, fraction = 2, message = "{product.vat-amount-format}", groups = SalesDocumentStep.class)
    private BigDecimal vatAmount;
    @NotNull(message = "{product.total-amount-required}", groups = SalesDocumentStep.class)
    @DecimalMin(value = "0.01", message = "{product.total-amount-min}", groups = SalesDocumentStep.class)
    @Digits(integer = 16, fraction = 2, message = "{product.total-amount-format}", groups = SalesDocumentStep.class)
    private BigDecimal totalAmount;
}
