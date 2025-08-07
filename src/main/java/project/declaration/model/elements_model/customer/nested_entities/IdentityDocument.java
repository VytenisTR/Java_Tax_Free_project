package project.declaration.model.elements_model.customer.nested_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import project.enums.IdentityDocumentTypes;
import project.enums.AllCountries;

@Embeddable
public class IdentityDocument {
    @Enumerated(EnumType.STRING)
    @Column(name = "identity_document_type", nullable = false)
    private IdentityDocumentTypes identityDocumentType;

    @Column(name = "identity_document_no", nullable = false)
    private String identityDocumentNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_issued_by", nullable = false)
    private AllCountries documentIssuedBy;
}
