package project.declaration.elements.customer;

import project.common.validation.customer.ValidPersonalIdNo;
import project.enums.EUCountries;
import project.enums.NonEUCountries;

public final class PersonIdentification {
    @ValidPersonalIdNo
    private String personalIdNumber;
    private EUCountries issuedByEUCountry;
    private NonEUCountries issuedByNonEUCountry;

    public PersonIdentification(final String personalIdNumber, final EUCountries issuedByEUCountry) {
        this.personalIdNumber = personalIdNumber;
        this.issuedByEUCountry = issuedByEUCountry;
    }

    public PersonIdentification(final String personalIdNumber, final NonEUCountries issuedByNonEUCountry) {
        this.personalIdNumber = personalIdNumber;
        this.issuedByNonEUCountry = issuedByNonEUCountry;
    }

    public PersonIdentification(final EUCountries issuedByEUCountry) {
        this.issuedByEUCountry = issuedByEUCountry;
    }

    public PersonIdentification(final NonEUCountries issuedByNonEUCountry) {
        this.issuedByNonEUCountry = issuedByNonEUCountry;
    }

    public String getPersonalIdNumber() {
        return personalIdNumber;
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
