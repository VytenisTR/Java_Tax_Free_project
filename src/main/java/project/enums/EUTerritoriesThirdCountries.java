package project.enums;

public enum EUTerritoriesThirdCountries {
    DE01("Austria", "Austrija"),
    DE02("Belgium", "Belgija"),
    ES01("Bulgaria", "Bulgarija"),
    ES02("Croatia", "Kroatija"),
    ES03("Cyprus", "Kipras"),
    IT01("Czech Republic", "Čekija"),
    IT02("Denmark", "Danija"),
    IT03("Estonia", "Estija"),
    FR01("Finland", "Suomija"),
    FR02("France", "Prancūzija"),
    FR03("Germany", "Vokietija"),
    FR04("Greece", "Graikija"),
    FR05("Hungary", "Vengrija"),
    FR06("Ireland", "Airija"),
    GR01("Italy", "Italija"),
    FI01("Latvia", "Latvija");

    private final String longEN;
    private final String longLT;

    EUTerritoriesThirdCountries(final String longEN, final String longLT) {
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
