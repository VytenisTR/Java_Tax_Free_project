package project.declaration.nested_dto.customer;

import jakarta.validation.Valid;
import lombok.*;
import project.declaration.nested_dto.customer.customer_dto.IdentityDocument;
import project.declaration.nested_dto.customer.customer_dto.Person;
import project.declaration.nested_dto.customer.customer_dto.PersonIdentification;
import project.declaration.nested_dto.customer.customer_dto.ResidentialDocument;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public final class CustomerDto {
    @Valid
    private Person person;
    @Valid
    private PersonIdentification personIdentification;
    @Valid
    private IdentityDocument identityDocument;
    @Valid
    private ResidentialDocument residentialDocument;
}
