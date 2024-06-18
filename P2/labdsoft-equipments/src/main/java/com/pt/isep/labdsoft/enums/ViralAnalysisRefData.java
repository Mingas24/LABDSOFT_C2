package com.pt.isep.labdsoft.enums;

public enum ViralAnalysisRefData {
    HBSAG_CMIA(1.00,1.00),
    HBSAG_MEIA(2.00,2.00),
    AC_HCV_CMIA(0.80,1.00),
    AC_HCV_ELISA(1.00,1.00);

    private final double lowerRefValue;
    private final double higherRefValue;

    ViralAnalysisRefData(double lowerRefValue, double higherRefValue) {
        this.lowerRefValue = lowerRefValue;
        this.higherRefValue = higherRefValue;
    }

    public double getLowerRefValue() {
        return lowerRefValue;
    }

    public double getHigherRefValue() {
        return higherRefValue;
    }
}
