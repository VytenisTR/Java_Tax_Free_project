package project.declaration.nested_dto.customer.customer_dto;

import lombok.*;
import project.common.validation.customer.ValidResidentialDocument;
import project.common.validation.customer.elements.ValidResidentialDocumentNo;
import project.declaration.validation.nested_steps.CustomerStep;
import project.enums.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ValidResidentialDocument(groups = CustomerStep.class)
public final class ResidentialDocument {
    private ResidentialDocumentTypes residentialDocumentType;
    @ValidResidentialDocumentNo(groups = CustomerStep.class)
    private String residentialDocumentNo;
    private EUTerritoriesWithNonEUCountries residentialDocumentIssuedBy;
    private NonEUCountries residentialCountry;
    private EUTerritoriesThirdCountries residentialEUTerritory;
}
