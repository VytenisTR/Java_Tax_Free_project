package project.enums;

public enum EUTerritoriesThirdCountries {
    IT02("Campione d'Italia", "Kampionė"),
    ES01("Ceuta", "Seuta"),
    FR02("French Guiana", "Prancūzijos Gviana"),
    FR01("Guadeloupe", "Gvadelupa"),
    IT01("Livigno", "Livinjas"),
    FR03("Martinique", "Martinika"),
    FR04("Mayotte", "Majotas"),
    ES02("Melilla", "Melilija"),
    GR01("Mount Athos", "Atono kalnas"),
    FR05("Reunion", "Reunjonas"),
    FR06("Saint-Martin", "Sen Martenas"),
    FI01("The Aland Islands", "Alandų salos"),
    ES03("The Canary Islands", "Kanarų salos"),
    DE01("The Island of Heligoland", "Helgolando sala"),
    IT03("The Italian waters of Lake Lugano", "Lugano ežero Italijos teritoriniai vandenys"),
    DE02("The territory of Busingen", "Biuzingeno teritorija");

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
