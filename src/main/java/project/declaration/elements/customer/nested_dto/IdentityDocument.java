package project.declaration.elements.customer.nested_dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.common.validation.customer.elements.ValidIdentityDocumentNo;
import project.enums.AllCountries;
import project.enums.IdentityDocumentTypes;

@NoArgsConstructor
@Getter
@Setter
public final class IdentityDocument {
    @NotNull(message = "Identity document type is required.")
    private IdentityDocumentTypes identityDocumentType;
    @NotBlank(message = "Identity document number is required.")
    @ValidIdentityDocumentNo
    private String identityDocumentNo;
    @NotNull(message = "Identity document issuer is required.")
    private AllCountries documentIssuedBy;
}
