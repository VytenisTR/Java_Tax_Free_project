package project.declaration.model.elements.customer.nested_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import project.enums.*;

@Embeddable
public class ResidentialDocument {
    @Enumerated(EnumType.STRING)
    @Column(name = "residential_document_type")
    private ResidentialDocumentTypes residentialDocumentType;

    @Column(name = "residential_document_no")
    private String residentialDocumentNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "residential_document_issued_by")
    private EUTerritoriesWithNonEUCountries residentialDocumentIssuedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "residential_country")
    private NonEUCountries residentialCountry;

    @Enumerated(EnumType.STRING)
    @Column(name = "residential_eu_territory")
    private EUTerritoriesThirdCountries residentialEUTerritory;
}
