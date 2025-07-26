package project.declaration.model.elements.customer.nested_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import project.enums.AllCountries;

@Embeddable
public class PersonIdentification {
    @Column(name = "personal_id_number")
    private String personalIdNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "id_issued_by")
    private AllCountries idIssuedBy;
}
