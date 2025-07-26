package project.declaration.elements.customer.nested_dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.common.validation.customer.ValidResidentialDocument;
import project.common.validation.customer.elements.ValidResidentialDocumentNo;
import project.enums.*;

@NoArgsConstructor
@Getter
@Setter
@ValidResidentialDocument
public final class ResidentialDocument {
    private ResidentialDocumentTypes residentialDocumentType;
    @ValidResidentialDocumentNo
    private String residentialDocumentNo;
    private EUTerritoriesWithNonEUCountries residentialDocumentIssuedBy;
    private NonEUCountries residentialCountry;
    private EUTerritoriesThirdCountries residentialEUTerritory;
}
