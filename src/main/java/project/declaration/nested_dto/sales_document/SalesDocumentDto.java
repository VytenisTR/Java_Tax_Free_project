package project.declaration.nested_dto.sales_document;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import project.common.validation.sales_document.ValidSalesDocument;
import project.declaration.nested_dto.sales_document.sales_document_dto.CashRegisterReceipt;
import project.declaration.nested_dto.sales_document.sales_document_dto.Invoice;
import project.declaration.nested_dto.sales_document.sales_document_dto.ProductDto;
import project.declaration.validation.nested_steps.SalesDocumentStep;
import project.enums.SalesDocumentTypes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ValidSalesDocument(groups = SalesDocumentStep.class)
public final class SalesDocumentDto {
    private SalesDocumentTypes salesDocumentType;
    @Valid
    private CashRegisterReceipt cashRegisterReceipt;
    @Valid
    private Invoice invoice;
    @NotNull(message = "{sales-document.sales-date-required}", groups = SalesDocumentStep.class)
    @PastOrPresent(message = "{sales-document.sales-date-in-future}", groups = SalesDocumentStep.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate salesDate;
    @Builder.Default
    @Size(min = 1, message = "{product.products-size}", groups = SalesDocumentStep.class)
    @Valid
    private List<ProductDto> products = new ArrayList<>();
}
