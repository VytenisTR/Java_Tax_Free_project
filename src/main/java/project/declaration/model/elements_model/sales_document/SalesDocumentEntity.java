package project.declaration.model.elements_model.sales_document;

import jakarta.persistence.*;
import lombok.*;
import project.declaration.nested_dto.sales_document.sales_document_dto.CashRegisterReceipt;
import project.declaration.nested_dto.sales_document.sales_document_dto.Invoice;
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
    @AttributeOverrides({
            @AttributeOverride(name = "cashRegisterNo", column = @Column(name = "cash_register_no")),
            @AttributeOverride(name = "cashReceiptNo", column = @Column(name = "cash_receipt_no"))
    })
    private CashRegisterReceipt cashRegisterReceipt;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "invoiceNo", column = @Column(name = "invoice_no"))
    })
    private Invoice invoice;

    @Column(name = "sales_date", nullable = false)
    private LocalDate salesDate;

    @OneToMany(mappedBy = "salesDocument", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products;

    @OneToOne(mappedBy = "salesDocument")
    private DeclarationEntity declaration;
}