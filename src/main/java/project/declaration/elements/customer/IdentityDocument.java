package project.declaration.elements.customer;

import project.common.validation.customer.ValidIdentityDocumentNo;
import project.enums.EUCountries;
import project.enums.IdentityDocumentTypes;
import project.enums.NonEUCountries;

public final class IdentityDocument {
    private final IdentityDocumentTypes identityDocumentType;
    @ValidIdentityDocumentNo
    private final String identityDocumentNo;
    private EUCountries issuedByEUCountry;
    private NonEUCountries issuedByNonEUCountry;

    public IdentityDocument(final IdentityDocumentTypes identityDocumentType, final String identityDocumentNo,
                            final EUCountries issuedByEUCountry) {
        this.identityDocumentType = identityDocumentType;
        this.identityDocumentNo = identityDocumentNo;
        this.issuedByEUCountry = issuedByEUCountry;
    }

    public IdentityDocument(final IdentityDocumentTypes identityDocumentType, final String identityDocumentNo,
                            final NonEUCountries issuedByNonEUCountry) {
        this.identityDocumentType = identityDocumentType;
        this.identityDocumentNo = identityDocumentNo;
        this.issuedByNonEUCountry = issuedByNonEUCountry;
    }

    public String getIdentityDocumentTypeEN() {
        return identityDocumentType.getLongEN();
    }

    public String getIdentityDocumentTypeLT() {
        return identityDocumentType.getLongLT();
    }

    public String getIdentityDocumentNo() {
        return identityDocumentNo;
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
}
