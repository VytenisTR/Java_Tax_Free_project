package project.declaration.elements_dto.customer.nested_dto;

import lombok.*;
import project.common.validation.customer.ValidResidentialDocument;
import project.common.validation.customer.elements.ValidResidentialDocumentNo;
import project.enums.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ValidResidentialDocument
public final class ResidentialDocument {
    private ResidentialDocumentTypes residentialDocumentType;
    @ValidResidentialDocumentNo
    private String residentialDocumentNo;
    private EUTerritoriesWithNonEUCountries residentialDocumentIssuedBy;
    private NonEUCountries residentialCountry;
    private EUTerritoriesThirdCountries residentialEUTerritory;
}
