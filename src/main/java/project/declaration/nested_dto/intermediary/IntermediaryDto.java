package project.declaration.nested_dto.intermediary;

import lombok.*;
import project.common.validation.intermediary.ValidIntermediary;
import project.common.validation.intermediary.elements.ValidIntermediaryIdNo;
import project.common.validation.intermediary.elements.ValidIntermediaryName;
import project.declaration.validation.nested_steps.IntermediaryStep;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ValidIntermediary(groups = IntermediaryStep.class)
public final class IntermediaryDto {
    private boolean noIntermediaryUsed;
    @ValidIntermediaryName(groups = IntermediaryStep.class)
    private String intermediaryName;
    @ValidIntermediaryIdNo(groups = IntermediaryStep.class)
    private String intermediaryIdNumber;
}
