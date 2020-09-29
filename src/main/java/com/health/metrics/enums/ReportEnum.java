package com.health.metrics.enums;

public enum ReportEnum {
    DAILY(1),
    WEEKLY(7),
    DUMMY(0);

    private int i;

    ReportEnum(int i) {
        this.i = i;
    }
}
