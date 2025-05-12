package project.declaration.elements.customer;

import project.enums.EUCountries;
import project.enums.IdentityDocumentTypes;
import project.enums.NonEUCountries;

public final class IdentityDocument {
    private final IdentityDocumentTypes identityDocumentType;
    private final long documentNo;
    private EUCountries issuedByEUCountry;
    private NonEUCountries issuedByNonEUCountry;

    public IdentityDocument(final IdentityDocumentTypes identityDocumentType, final long documentNo,
                            final EUCountries issuedByEUCountry) {
        this.identityDocumentType = identityDocumentType;
        this.documentNo = documentNo;
        this.issuedByEUCountry = issuedByEUCountry;
    }

    public IdentityDocument(final IdentityDocumentTypes identityDocumentType, final long documentNo,
                            final NonEUCountries issuedByNonEUCountry) {
        this.identityDocumentType = identityDocumentType;
        this.documentNo = documentNo;
        this.issuedByNonEUCountry = issuedByNonEUCountry;
    }

    public String getIdentityDocumentTypeEN() {
        return identityDocumentType.getLongEN();
    }

    public String getIdentityDocumentTypeLT() {
        return identityDocumentType.getLongLT();
    }

    public long getDocumentNo() {
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
}
