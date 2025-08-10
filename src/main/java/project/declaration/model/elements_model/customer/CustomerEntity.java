package project.declaration.model.elements_model.customer;

import jakarta.persistence.*;
import lombok.*;
import project.declaration.nested_dto.customer.customer_dto.IdentityDocument;
import project.declaration.nested_dto.customer.customer_dto.Person;
import project.declaration.nested_dto.customer.customer_dto.PersonIdentification;
import project.declaration.nested_dto.customer.customer_dto.ResidentialDocument;
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
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name")),
            @AttributeOverride(name = "birthDate", column = @Column(name = "birthdate"))
    })
    private Person person;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "personalIdNumber", column = @Column(name = "personal_id_number")),
            @AttributeOverride(name = "idIssuedBy", column = @Column(name = "id_issued_by"))
    })
    private PersonIdentification personIdentification;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "identityDocumentType",
                    column = @Column(name = "identity_document_type")),
            @AttributeOverride(name = "identityDocumentNo", column = @Column(name = "identity_document_no")),
            @AttributeOverride(name = "documentIssuedBy", column = @Column(name = "document_issued_by"))
    })
    private IdentityDocument identityDocument;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "residentialDocumentType",
                    column = @Column(name = "residential_document_type")),
            @AttributeOverride(name = "residentialDocumentNo",
                    column = @Column(name = "residential_document_no")),
            @AttributeOverride(name = "residentialDocumentIssuedBy",
                    column = @Column(name = "residential_document_issued_by")),
            @AttributeOverride(name = "residentialCountry",
                    column = @Column(name = "residential_country")),
            @AttributeOverride(name = "residentialEUTerritory",
                    column = @Column(name = "residential_eu_territory"))
    })
    private ResidentialDocument residentialDocument;

    @OneToOne(mappedBy = "customer")
    private DeclarationEntity declaration;
}

