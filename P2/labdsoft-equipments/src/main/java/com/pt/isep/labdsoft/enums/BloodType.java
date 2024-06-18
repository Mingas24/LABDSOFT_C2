package com.pt.isep.labdsoft.enums;

public enum BloodType {
    ANEGATIVE("A-"),
    APOSITIVE("A+"),
    BNEGATIVE("B-"),
    BPOSITIVE("B+"),
    ONEGATIVE("O-"),
    OPOSITIVE("O+"),
    OBNEGATIVE("OB-"),
    OBPOSITIVE("OB+");

    private final String value;

    BloodType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
