package project.enums;

public enum MeasurementUnits {
    ASV("% vol", "Alkoholio koncentracija, išreikšta tūrio procentais"),
    CEN("100 p/st", "Šimtas vienetų"),
    MIL("1000 p/st", "Tūkstantis vienetų"),
    KLT("1000 l", "Tūkstantis litrų"),
    GRM("g", "Gramas"),
    HLT("hl", "Hektolitras"),
    KGM("kg", "Kilogramas"),
    LPA("l alc. 100%", "Litras grynojo (100 proc.) alkoholio"),
    LTR("l", "Litras"),
    NAR("p/st", "Vienetų skaičius"),
    NPR("pa", "Porų skaičius");

    private final String shortLTEN;
    private final String longLT;

    MeasurementUnits(final String shortLTEN, final String longLT) {
        this.shortLTEN = shortLTEN;
        this.longLT = longLT;
    }

    public String getShortLTEN() {
        return shortLTEN;
    }

    public String getLongLT() {
        return longLT;
    }
}
