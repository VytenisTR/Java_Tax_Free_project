package project.declaration.model.elements.sales_document;

import jakarta.persistence.*;
import lombok.*;
import project.declaration.elements.sales_document.nested_dto.CashRegisterReceipt;
import project.declaration.elements.sales_document.nested_dto.Invoice;
import project.declaration.model.DeclarationEntity;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sales_document")
public class SalesDocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CashRegisterReceipt cashRegisterReceipt;

    @Embedded
    private Invoice invoice;

    @Column(name = "sales_date", nullable = false)
    private LocalDate salesDate;

    @OneToMany(mappedBy = "salesDocument", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products;

    @OneToOne(mappedBy = "salesDocument")
    private DeclarationEntity declaration;
}