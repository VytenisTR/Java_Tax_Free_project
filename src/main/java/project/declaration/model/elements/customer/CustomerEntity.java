package project.declaration.model.elements.customer;

import jakarta.persistence.*;
import lombok.*;
import project.declaration.elements.customer.nested_dto.IdentityDocument;
import project.declaration.elements.customer.nested_dto.Person;
import project.declaration.elements.customer.nested_dto.PersonIdentification;
import project.declaration.elements.customer.nested_dto.ResidentialDocument;
import project.declaration.model.DeclarationEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Person person;

    @Embedded
    private PersonIdentification personIdentification;

    @Embedded
    private IdentityDocument identityDocument;

    @Embedded
    private ResidentialDocument residentialDocument;

    @OneToOne(mappedBy = "customer")
    private DeclarationEntity declaration;
}

