package project.declaration.model.elements.intermediary;

import jakarta.persistence.*;
import lombok.*;
import project.declaration.model.DeclarationEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "intermediary")
public class IntermediaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "no_intermediary_used", nullable = false)
    private boolean noIntermediaryUsed;

    @Column(name = "intermediary_name")
    private String intermediaryName;

    @Column(name = "intermediary_id_number")
    private String intermediaryIdNumber;

    @OneToOne(mappedBy = "intermediary")
    private DeclarationEntity declaration;
}

