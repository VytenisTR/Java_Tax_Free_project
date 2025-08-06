package project.enums;

public enum DeclarationWizardSteps {
    SALESMAN("Salesman", "Pardavėjas"),
    CUSTOMER("Customer", "Pirkėjas"),
    SALES_DOCUMENT("Sales document", "Pardavimo dokumentas"),
    INTERMEDIARY("Intermediary", "Tarpininkas");

    private final String longEN;
    private final String longLT;

    DeclarationWizardSteps(final String longEN, final String longLT) {
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


