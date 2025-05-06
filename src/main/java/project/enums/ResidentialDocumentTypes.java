package project.enums;

public enum ResidentialDocumentTypes {
    CERTIFICATE("Certificate", "Pažyma"),
    EXCERPT("Excerpt", "Išrašas"),
    OTHER("Other", "Kita");

    private final String longEN;
    private final String longLT;

    ResidentialDocumentTypes(final String longEN, final String longLT) {
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
