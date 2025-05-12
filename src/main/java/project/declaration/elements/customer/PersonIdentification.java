package project.declaration.elements.customer;

import project.enums.EUCountries;
import project.enums.NonEUCountries;

public final class PersonIdentification {
    private final long personalIdNumber;
    private EUCountries issuedByEUCountry;
    private NonEUCountries issuedByNonEUCountry;

    public PersonIdentification(final long personalIdNumber, final EUCountries issuedByEUCountry) {
        this.personalIdNumber = personalIdNumber;
        this.issuedByEUCountry = issuedByEUCountry;
    }

    public PersonIdentification(final long personalIdNumber, final NonEUCountries issuedByNonEUCountry) {
        this.personalIdNumber = personalIdNumber;
        this.issuedByNonEUCountry = issuedByNonEUCountry;
    }

    public long getPersonalIdNumber() {
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
