package project.declaration.dto;

import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import project.declaration.elements.customer.CustomerDto;
import project.declaration.elements.intermediary.IntermediaryDto;
import project.declaration.elements.sales_document.SalesDocumentDto;
import project.declaration.elements.salesman.SalesmanDto;

@Getter
@Setter
@Builder
public final class DeclarationDto {
    @Valid
    private SalesmanDto salesmanDto;
    @Valid
    private CustomerDto customerDto;
    @Valid
    private SalesDocumentDto salesDocumentDto;
    @Valid
    private IntermediaryDto intermediaryDto;
}
