package project.declaration.nested_dto.customer.customer_dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import project.common.validation.customer.elements.ValidIdentityDocumentNo;
import project.declaration.validation.nested_steps.CustomerStep;
import project.enums.AllCountries;
import project.enums.IdentityDocumentTypes;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public final class IdentityDocument {
    @NotNull(message = "{identity-document.identity-document-type-required}", groups = CustomerStep.class)
    private IdentityDocumentTypes identityDocumentType;
    @NotBlank(message = "{identity-document.identity-document-no-required}", groups = CustomerStep.class)
    @ValidIdentityDocumentNo(groups = CustomerStep.class)
    private String identityDocumentNo;
    @NotNull(message = "{identity-document.identity-document-issued-by-required}", groups = CustomerStep.class)
    private AllCountries documentIssuedBy;
}
