package project.declaration.dto;

import project.common.validation.intermediary.ValidIntermediaryIdNo;
import project.common.validation.intermediary.ValidIntermediaryName;

public final class IntermediaryDto {
    @ValidIntermediaryName
    private final String intermediaryName;
    @ValidIntermediaryIdNo
    private final long intermediaryIdNumber;

    public IntermediaryDto(final String intermediaryName, final long intermediaryIdNumber) {
        this.intermediaryName = intermediaryName;
        this.intermediaryIdNumber = intermediaryIdNumber;
    }

    public String getIntermediaryName() {
        return intermediaryName;
    }

    public long getIntermediaryIdNumber() {
        return intermediaryIdNumber;
    }
}
