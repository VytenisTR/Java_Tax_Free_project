package project.enums;

public enum MeasurementUnits {
    ASV("% vol", "Alkoholio koncentracija, išreikšta tūrio procentais"),
    CEN("100 p/st", "Šimtas vienetų"),
    GRM("g", "Gramas"),
    HLT("hl", "Hektolitras"),
    KGM("kg", "Kilogramas"),
    KLT("1000 l", "Tūkstantis litrų"),
    LPA("l alc. 100%", "Litras grynojo (100 proc.) alkoholio"),
    LTR("l", "Litras"),
    MIL("1000 p/st", "Tūkstantis vienetų"),
    NAR("p/st", "Vienetų skaičius"),
    NPR("pa", "Porų skaičius");

    private final String shortLT;
    private final String longLT;

    MeasurementUnits(final String shortLT, final String longLT) {
        this.shortLT = shortLT;
        this.longLT = longLT;
    }

    public String getShortLT() {
        return shortLT;
    }

    public String getLongLT() {
        return longLT;
    }
}
