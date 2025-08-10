package project.declaration.nested_dto.customer.customer_dto;

import lombok.*;
import project.common.validation.customer.ValidPersonIdentification;
import project.common.validation.customer.elements.ValidPersonalIdNo;
import project.declaration.validation.nested_steps.CustomerStep;
import project.enums.AllCountries;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ValidPersonIdentification(groups = CustomerStep.class)
public final class PersonIdentification {
    @ValidPersonalIdNo(groups = CustomerStep.class)
    private String personalIdNumber;
    private AllCountries idIssuedBy;
}
