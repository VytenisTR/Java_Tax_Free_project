package project.declaration.dto;

public final class IntermediaryDto {
    private final String intermediaryName;
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
