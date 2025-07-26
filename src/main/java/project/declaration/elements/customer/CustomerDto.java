package project.declaration.elements.customer;

import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import project.declaration.elements.customer.nested_dto.IdentityDocument;
import project.declaration.elements.customer.nested_dto.Person;
import project.declaration.elements.customer.nested_dto.PersonIdentification;
import project.declaration.elements.customer.nested_dto.ResidentialDocument;

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
