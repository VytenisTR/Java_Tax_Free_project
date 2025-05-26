package project.declaration.elements.customer;

import project.common.validation.customer.ValidResidentialDocumentNo;
import project.enums.EUCountries;
import project.enums.NonEUCountries;
import project.enums.ResidentialDocumentTypes;
import project.enums.EUTerritoriesThirdCountries;

public final class ResidentialDocument {
    private final ResidentialDocumentTypes residentialDocumentType;
    @ValidResidentialDocumentNo
    private final String documentNo;
    private EUCountries issuedByEUCountry;
    private NonEUCountries issuedByNonEUCountry;
    private EUTerritoriesThirdCountries residentialEUTerritory;

    public ResidentialDocument(final ResidentialDocumentTypes residentialDocumentType, final String documentNo,
                               final EUCountries issuedByEUCountry,
                               final EUTerritoriesThirdCountries residentialEUTerritory) {
        this.residentialDocumentType = residentialDocumentType;
        this.documentNo = documentNo;
        this.issuedByEUCountry = issuedByEUCountry;
        this.residentialEUTerritory = residentialEUTerritory;
    }

    public ResidentialDocument(final ResidentialDocumentTypes residentialDocumentType, final String documentNo,
                               final NonEUCountries issuedByNonEUCountry) {
        this.residentialDocumentType = residentialDocumentType;
        this.documentNo = documentNo;
        this.issuedByNonEUCountry = issuedByNonEUCountry;
    }

    public String getResidentialDocumentTypeEN() {
        return residentialDocumentType.getLongEN();
    }

    public String getResidentialDocumentTypeLT() {
        return residentialDocumentType.getLongLT();
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public String getIssuedByEUCountryEN() {
        return issuedByEUCountry.getLongEN();
    }

    public String getIssuedByEUCountryLT() {
        return issuedByEUCountry.getLongLT();
    }

    public String getIssuedByNonEUCountryEN() {
        return issuedByNonEUCountry.getLongEN();
    }

    public String getIssuedByNonEUCountryLT() {
        return issuedByNonEUCountry.getLongLT();
    }

    public String getResidentialEUTerritoryCode() {
        return residentialEUTerritory.toString();
    }

    public String getResidentialEUTerritoryEN() {
        return residentialEUTerritory.getLongEN();
    }

    public String getResidentialEUTerritoryLT() {
        return residentialEUTerritory.getLongLT();
    }
}
