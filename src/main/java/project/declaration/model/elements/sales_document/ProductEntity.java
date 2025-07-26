package project.declaration.model.elements.sales_document;

import jakarta.persistence.*;
import lombok.*;
import project.enums.MeasurementUnits;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "product_quantity", nullable = false)
    private Integer productQuantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "measurement_units")
    private MeasurementUnits measurementUnits;

    @Column(name = "measurement_units_other")
    private String measurementUnitsOther;

    @Column(name = "taxable_amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal taxableAmount;

    @Column(name = "vat_amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal vatAmount;

    @Column(name = "total_amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_document_id", nullable = false)
    private SalesDocumentEntity salesDocument;
}
