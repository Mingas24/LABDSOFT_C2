package com.pt.isep.labdsoft.enums;

public enum StatusCode {
    OK(200),
    CREATED(201),
    UPDATED(204),
    AUTHENTICATION_FAILED(401),
    ACCESS_DENIED(403),
    NOT_FOUND(404),
    OPERATION_EXCEPTION(2000),
    ALREADY_EXISTS(2001);

    private final int value;

    StatusCode(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
