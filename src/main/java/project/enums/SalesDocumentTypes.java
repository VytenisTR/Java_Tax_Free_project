package project.enums;

public enum SalesDocumentTypes {
    CASH_REGISTER_RECEIPT("Cash register receipt", "Kasos aparato kvitas"),
    INVOICE("Invoice", "Kitas atsiskaitymo dokumentas");

    private final String longEN;
    private final String longLT;

    SalesDocumentTypes(final String longEN, final String longLT) {
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
