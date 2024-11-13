package com.example.timescaledb.sensor.view.common;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@IdClass(SensorDataViewId.class)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SensorDataView {

    @Id
    private UUID sensorId;

    private String frame;
    private double min;
    private double max;
    private double avg;

    public SensorDataView() {}

    public SensorDataView(UUID sensorId, String frame, double min, double max, double avg) {
        this.sensorId = sensorId;
        this.frame = frame;
        this.min = min;
        this.max = max;
        this.avg = avg;
    }

    public UUID getSensorId() {
        return sensorId;
    }

    public void setSensorId(UUID sensorId) {
        this.sensorId = sensorId;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
}
