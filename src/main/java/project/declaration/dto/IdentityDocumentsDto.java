package project.declaration.dto;

public final class IdentityDocumentsDto {
    private final String identityDocumentsLabel;
    private final String identityDocumentsValue;

    public IdentityDocumentsDto(final String identityDocumentsLabel,
                                final String identityDocumentsValue) {
        this.identityDocumentsLabel = identityDocumentsLabel;
        this.identityDocumentsValue = identityDocumentsValue;
    }

    public String getIdentityDocumentsLabel() {
        return identityDocumentsLabel;
    }

    public String getIdentityDocumentsValue() {
        return identityDocumentsValue;
    }
}
