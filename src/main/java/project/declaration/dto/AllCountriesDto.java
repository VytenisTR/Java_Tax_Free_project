package project.declaration.dto;

public final class AllCountriesDto {
    private final String allCountriesLabel;
    private final String allCountriesValue;

    public AllCountriesDto(final String allCountriesLabel,
                           final String allCountriesValue) {
        this.allCountriesLabel = allCountriesLabel;
        this.allCountriesValue = allCountriesValue;
    }

    public String getAllCountriesLabel() {
        return allCountriesLabel;
    }

    public String getAllCountriesValue() {
        return allCountriesValue;
    }
}
