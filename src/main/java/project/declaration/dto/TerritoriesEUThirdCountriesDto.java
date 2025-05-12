package project.declaration.dto;

public final class TerritoriesEUThirdCountriesDto {
    private final String territoriesEUThirdCountriesLabel;
    private final String territoriesEUThirdCountriesValue;

    public TerritoriesEUThirdCountriesDto(final String territoriesEUThirdCountriesLabel,
                                          final String territoriesEUThirdCountriesValue) {
        this.territoriesEUThirdCountriesLabel = territoriesEUThirdCountriesLabel;
        this.territoriesEUThirdCountriesValue = territoriesEUThirdCountriesValue;
    }

    public String getTerritoriesEUThirdCountriesLabel() {
        return territoriesEUThirdCountriesLabel;
    }

    public String getTerritoriesEUThirdCountriesValue() {
        return territoriesEUThirdCountriesValue;
    }
}
