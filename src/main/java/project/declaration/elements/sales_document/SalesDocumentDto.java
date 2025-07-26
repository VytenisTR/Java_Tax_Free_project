package project.declaration.elements.sales_document;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import project.common.validation.sales_document.ValidSalesDocument;
import project.declaration.elements.sales_document.nested_dto.CashRegisterReceipt;
import project.declaration.elements.sales_document.nested_dto.Invoice;
import project.declaration.elements.sales_document.nested_dto.ProductDto;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@ValidSalesDocument
public final class SalesDocumentDto {
    @Valid
    private CashRegisterReceipt cashRegisterReceipt;
    @Valid
    private Invoice invoice;
    @NotNull(message = "Sales date is required.")
    @PastOrPresent(message = "Sales date cannot be in the future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate salesDate;
    @Size(min = 1, message = "At least one product is required.")
    @Valid
    private List<ProductDto> products;
}
