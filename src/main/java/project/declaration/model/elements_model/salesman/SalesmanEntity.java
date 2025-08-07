package project.declaration.model.elements_model.salesman;

import jakarta.persistence.*;
import lombok.*;
import project.declaration.model.DeclarationEntity;
import project.enums.EUCountries;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "salesman")
public class SalesmanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vat_payer_code", nullable = false)
    private String vatPayerCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "vat_code_issuer", nullable = false)
    private EUCountries vatCodeIssuer;

    @Column(name = "salesman_name", nullable = false)
    private String salesmanName;

    @OneToOne(mappedBy = "salesman")
    private DeclarationEntity declaration;
}
