package project.enums;

//ISO-3166 Alpha 2 EU countries
public enum EUCountries {
    AT("Austria", "Austrija"),
    BE("Belgium", "Belgija"),
    BG("Bulgaria", "Bulgarija"),
    HR("Croatia", "Kroatija"),
    CY("Cyprus", "Kipras"),
    CZ("Czech Republic", "Čekija"),
    DK("Denmark", "Danija"),
    EE("Estonia", "Estija"),
    FI("Finland", "Suomija"),
    FR("France", "Prancūzija"),
    DE("Germany", "Vokietija"),
    GR("Greece", "Graikija"),
    HU("Hungary", "Vengrija"),
    IE("Ireland", "Airija"),
    IT("Italy", "Italija"),
    LV("Latvia", "Latvija"),
    LT("Lithuania", "Lietuva"),
    LU("Luxembourg", "Liuksemburgas"),
    MT("Malta", "Malta"),
    NL("Netherlands", "Nyderlandai"),
    PL("Poland", "Lenkija"),
    PT("Portugal", "Portugalija"),
    RO("Romania", "Rumunija"),
    SK("Slovakia", "Slovakija"),
    SI("Slovenia", "Slovėnija"),
    ES("Spain", "Ispanija"),
    SE("Sweden", "Švedija");

    private final String longEN;
    private final String longLT;

    EUCountries(final String longEN, final String longLT) {
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
