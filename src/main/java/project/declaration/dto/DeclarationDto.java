package project.declaration.dto;

import jakarta.validation.Valid;
import lombok.*;
import project.declaration.nested_dto.customer.CustomerDto;
import project.declaration.nested_dto.intermediary.IntermediaryDto;
import project.declaration.nested_dto.sales_document.SalesDocumentDto;
import project.declaration.nested_dto.salesman.SalesmanDto;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
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
