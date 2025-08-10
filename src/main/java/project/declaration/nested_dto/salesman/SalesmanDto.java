package project.declaration.nested_dto.salesman;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import project.common.validation.salesman.ValidSalesmanName;
import project.common.validation.salesman.ValidVatCodeIssuer;
import project.common.validation.salesman.ValidVatPayerCode;
import project.declaration.validation.nested_steps.SalesmanStep;
import project.enums.EUCountries;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public final class SalesmanDto {
    @NotBlank(message = "{salesman.vat-payer-code-required}", groups = SalesmanStep.class)
    @ValidVatPayerCode(groups = SalesmanStep.class)
    private String vatPayerCode;
    @NotNull(message = "{salesman.vat-code-issuer-required}", groups = SalesmanStep.class)
    @ValidVatCodeIssuer(groups = SalesmanStep.class)
    private EUCountries vatCodeIssuer;
    @NotBlank(message = "{salesman.salesman-name-required}", groups = SalesmanStep.class)
    @ValidSalesmanName(groups = SalesmanStep.class)
    private String salesmanName;
}
