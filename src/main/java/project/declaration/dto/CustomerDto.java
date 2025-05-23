package project.declaration.dto;

import project.declaration.elements.customer.IdentityDocument;
import project.declaration.elements.customer.Person;
import project.declaration.elements.customer.PersonIdentification;
import project.declaration.elements.customer.ResidentialDocument;

public final class CustomerDto {
    private final Person person;
    private final PersonIdentification personIdentification;
    private final IdentityDocument identityDocument;
    private ResidentialDocument residentialDocument;

    public CustomerDto(final Person person, final PersonIdentification personIdentification,
                    final IdentityDocument identityDocument) {
        this.person = person;
        this.personIdentification = personIdentification;
        this.identityDocument = identityDocument;
    }

    public CustomerDto(final Person person, final PersonIdentification personIdentification,
                    final IdentityDocument identityDocument, final ResidentialDocument residentialDocument) {
        this.person = person;
        this.personIdentification = personIdentification;
        this.identityDocument = identityDocument;
        this.residentialDocument = residentialDocument;
    }

    public Person getPerson() {
        return person;
    }

    public PersonIdentification getPersonIdentification() {
        return personIdentification;
    }

    public IdentityDocument getIdentityDocument() {
        return identityDocument;
    }

    public ResidentialDocument getResidentialDocument() {
        return residentialDocument;
    }
}
