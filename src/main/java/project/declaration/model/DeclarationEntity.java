package project.declaration.model;

import jakarta.persistence.*;
import lombok.*;
import project.declaration.model.elements.customer.CustomerEntity;
import project.declaration.model.elements.intermediary.IntermediaryEntity;
import project.declaration.model.elements.sales_document.SalesDocumentEntity;
import project.declaration.model.elements.salesman.SalesmanEntity;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "declarations")
public class DeclarationEntity {
    @Id
    @GeneratedValue
    @Column(name = "declaration_uuid", updatable = false, nullable = false)
    private UUID declarationUUID;

    @Column(name = "declaration_date", nullable = false)
    private LocalDate declarationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salesman_id", referencedColumnName = "id")
    private SalesmanEntity salesman;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerEntity customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sales_document_id", referencedColumnName = "id")
    private SalesDocumentEntity salesDocument;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "intermediary_id", referencedColumnName = "id")
    private IntermediaryEntity intermediary;

    @PostPersist
    public void linkBidirectionalDBRelationships() {
        if (salesman != null) salesman.setDeclaration(this);
        if (customer != null) customer.setDeclaration(this);
        if (salesDocument != null) salesDocument.setDeclaration(this);
        if (intermediary != null) intermediary.setDeclaration(this);
    }
}

