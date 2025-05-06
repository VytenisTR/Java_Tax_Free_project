package project.declaration.elements;

import project.declaration.elements.subelements.IdentityDocument;
import project.declaration.elements.subelements.Person;
import project.declaration.elements.subelements.PersonIdentification;
import project.declaration.elements.subelements.ResidentialDocument;

public final class Customer {
    private final Person person;
    private final PersonIdentification personIdentification;
    private final IdentityDocument identityDocument;
    private ResidentialDocument residentialDocument;

    public Customer(final Person person, final PersonIdentification personIdentification,
                    final IdentityDocument identityDocument) {
        this.person = person;
        this.personIdentification = personIdentification;
        this.identityDocument = identityDocument;
    }

    public Customer(final Person person, final PersonIdentification personIdentification,
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
