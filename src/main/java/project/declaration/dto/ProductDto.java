package project.declaration.dto;

import project.core.DeclarationConstants;
import project.enums.MeasurementUnits;

public final class ProductDto {
    private final long productSequenceNo;
    private final String productDescription;
    private final long productQuantity;
    private MeasurementUnits measurementUnits;
    private String measurementUnitsOther;
    private final double taxableAmount;
    private final double vatAmount;
    private final double totalAmount;

    public ProductDto(final String productDescription, final long productQuantity,
                      final MeasurementUnits measurementUnits, final double taxableAmount,
                      final double vatAmount, final double totalAmount) {
        this.productSequenceNo = DeclarationConstants.getProductSequenceNumber();
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.measurementUnits = measurementUnits;
        this.taxableAmount = taxableAmount;
        this.vatAmount = vatAmount;
        this.totalAmount = totalAmount;
        DeclarationConstants.incrementProductSequenceNumber();
    }

    public ProductDto(final String productDescription, final long productQuantity,
                      final String measurementUnitsOther, final double taxableAmount,
                      final double vatAmount, final double totalAmount) {
        this.productSequenceNo = DeclarationConstants.getProductSequenceNumber();
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.measurementUnitsOther = measurementUnitsOther;
        this.taxableAmount = taxableAmount;
        this.vatAmount = vatAmount;
        this.totalAmount = totalAmount;
        DeclarationConstants.incrementProductSequenceNumber();
    }

    public long getProductSequenceNo() {
        return productSequenceNo;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public long getProductQuantity() {
        return productQuantity;
    }

    public String getMeasurementUnitsShortLT() {
        return measurementUnits.getShortLT();
    }

    public String getMeasurementUnitsLongLT() {
        return measurementUnits.getLongLT();
    }

    public String getMeasurementUnitsOther() {
        return measurementUnitsOther;
    }

    public double getTaxableAmount() {
        return taxableAmount;
    }

    public double getVatAmount() {
        return vatAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
