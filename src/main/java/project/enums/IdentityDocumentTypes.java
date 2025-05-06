package project.enums;

public enum IdentityDocumentTypes {
    IDENTITY_CARD("Identity card", "Asmens tapatybės kortelė"),
    PASSPORT("Passport", "Pasas");

    private final String longEN;
    private final String longLT;

    IdentityDocumentTypes(final String longEN, final String longLT) {
        this.longEN = longEN;
        this.longLT = longLT;
    }

    public String getLongEN() {
        return longEN;
    }

    public String getLongLT() {
        return longLT;
    }
}
