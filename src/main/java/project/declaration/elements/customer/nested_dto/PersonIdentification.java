package project.declaration.elements.customer.nested_dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.common.validation.customer.ValidPersonIdentification;
import project.common.validation.customer.elements.ValidPersonalIdNo;
import project.enums.AllCountries;

@NoArgsConstructor
@Getter
@Setter
@ValidPersonIdentification
public final class PersonIdentification {
    @ValidPersonalIdNo
    private String personalIdNumber;
    private AllCountries idIssuedBy;
}
