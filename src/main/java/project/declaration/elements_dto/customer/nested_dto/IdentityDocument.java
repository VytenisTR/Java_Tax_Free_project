package project.declaration.elements_dto.customer.nested_dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import project.common.validation.customer.elements.ValidIdentityDocumentNo;
import project.enums.AllCountries;
import project.enums.IdentityDocumentTypes;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public final class IdentityDocument {
    @NotNull(message = "{identity-document.identity-document-type-required}")
    private IdentityDocumentTypes identityDocumentType;
    @NotBlank(message = "{identity-document.identity-document-no-required}")
    @ValidIdentityDocumentNo
    private String identityDocumentNo;
    @NotNull(message = "{identity-document.identity-document-issued-by-required}")
    private AllCountries documentIssuedBy;
}
