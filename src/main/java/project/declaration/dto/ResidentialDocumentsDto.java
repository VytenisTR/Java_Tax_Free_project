package project.declaration.dto;

public final class ResidentialDocumentsDto {
    private final String residentialDocumentsLabel;
    private final String residentialDocumentsValue;

    public ResidentialDocumentsDto(final String residentialDocumentsLabel,
                                   final String residentialDocumentsValue) {
        this.residentialDocumentsLabel = residentialDocumentsLabel;
        this.residentialDocumentsValue = residentialDocumentsValue;
    }

    public String getResidentialDocumentsLabel() {
        return residentialDocumentsLabel;
    }

    public String getResidentialDocumentsValue() {
        return residentialDocumentsValue;
    }
}
