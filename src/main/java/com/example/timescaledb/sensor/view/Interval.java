package com.example.timescaledb.sensor.view;

public enum Interval {

    HOURLY("hourly"),
    DAILY("daily");

    private final String value;

    Interval(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Interval fromString(String text) {
        for (Interval interval : Interval.values()) {
            if (interval.value.equalsIgnoreCase(text)) {
                return interval;
            }
        }
        return null;
    }
}
