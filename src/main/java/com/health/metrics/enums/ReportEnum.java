package com.health.metrics.enums;

public enum ReportEnum {
    DAILY(1),
    WEEKLY(7),
    DUMMY(0);

    private int value;

    public int getValue() {
        return this.value;
    }

    ReportEnum(int value) {
        this.value = value;
    }
}
