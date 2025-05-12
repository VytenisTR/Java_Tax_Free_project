package project.declaration.dto;

public final class MeasurementUnitsDto {
    private final String measurementUnitsLabel;
    private final String measurementUnitsValue;

    public MeasurementUnitsDto(final String measurementUnitsLabel,
                               final String measurementUnitsValue) {
        this.measurementUnitsLabel = measurementUnitsLabel;
        this.measurementUnitsValue = measurementUnitsValue;
    }

    public String getMeasurementUnitsLabel() {
        return measurementUnitsLabel;
    }

    public String getMeasurementUnitsValue() {
        return measurementUnitsValue;
    }
}
