package project.declaration.elements_dto.customer.nested_dto;

import lombok.*;
import project.common.validation.customer.ValidPersonIdentification;
import project.common.validation.customer.elements.ValidPersonalIdNo;
import project.enums.AllCountries;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ValidPersonIdentification
public final class PersonIdentification {
    @ValidPersonalIdNo
    private String personalIdNumber;
    private AllCountries idIssuedBy;
}
