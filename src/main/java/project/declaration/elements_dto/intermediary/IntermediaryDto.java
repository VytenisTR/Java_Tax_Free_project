package project.declaration.elements_dto.intermediary;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import project.common.validation.intermediary.ValidIntermediary;
import project.common.validation.intermediary.elements.ValidIntermediaryIdNo;
import project.common.validation.intermediary.elements.ValidIntermediaryName;

@Getter
@Setter
@Builder
@ValidIntermediary
public final class IntermediaryDto {
    private boolean noIntermediaryUsed;
    @ValidIntermediaryName
    private String intermediaryName;
    @ValidIntermediaryIdNo
    private String intermediaryIdNumber;
}
