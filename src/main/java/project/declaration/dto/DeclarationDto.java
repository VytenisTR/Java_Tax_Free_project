package project.declaration.dto;

import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import project.declaration.elements_dto.customer.CustomerDto;
import project.declaration.elements_dto.intermediary.IntermediaryDto;
import project.declaration.elements_dto.sales_document.SalesDocumentDto;
import project.declaration.elements_dto.salesman.SalesmanDto;
import java.util.UUID;

@Getter
@Setter
@Builder
public final class DeclarationDto {
    private UUID declarationUUID;

    @Valid
    private SalesmanDto salesmanDto;
    @Valid
    private CustomerDto customerDto;
    @Valid
    private SalesDocumentDto salesDocumentDto;
    @Valid
    private IntermediaryDto intermediaryDto;
}
