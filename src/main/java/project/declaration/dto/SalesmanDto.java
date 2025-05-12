package project.declaration.dto;

import project.enums.EUCountries;

public final class SalesmanDto {
    private final long vatPayerCode;
    private final EUCountries vatCodeIssuer;
    private final String salesmanName;

    public SalesmanDto(final long vatPayerCode, final String salesmanName) {
        this.vatPayerCode = vatPayerCode;
        this.vatCodeIssuer = EUCountries.LT;
        this.salesmanName = salesmanName;
    }

    public long getVatPayerCode() {
        return vatPayerCode;
    }

    public String getVatCodeIssuerEN() {
        return vatCodeIssuer.getLongEN();
    }

    public String getVatCodeIssuerLT() {
        return vatCodeIssuer.getLongLT();
    }

    public String getSalesmanName() {
        return salesmanName;
    }
}
