package project.declaration.elements.salesman;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import project.common.validation.salesman.ValidSalesmanName;
import project.common.validation.salesman.ValidVatCodeIssuer;
import project.common.validation.salesman.ValidVatPayerCode;
import project.enums.EUCountries;

@Getter
@Setter
@Builder
public final class SalesmanDto {
    @NotBlank(message = "VAT payer code is required.")
    @ValidVatPayerCode
    private String vatPayerCode;
    @NotNull(message = "VAT code issuer is required.")
    @ValidVatCodeIssuer
    private EUCountries vatCodeIssuer;
    @NotBlank(message = "Salesman name is required.")
    @ValidSalesmanName
    private String salesmanName;
}
