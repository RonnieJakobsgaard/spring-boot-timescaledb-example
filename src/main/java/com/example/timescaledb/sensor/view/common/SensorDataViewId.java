package com.example.timescaledb.sensor.view.common;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class SensorDataViewId implements Serializable {

    private UUID sensorId;
    private String frame;

    public SensorDataViewId() {
    }

    public SensorDataViewId(UUID sensor, String frame) {
        this.sensorId = sensor;
        this.frame = frame;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SensorDataViewId that = (SensorDataViewId) o;

        if (!Objects.equals(sensorId, that.sensorId)) return false;
        return Objects.equals(frame, that.frame);
    }

    @Override
    public int hashCode() {
        int result = sensorId != null ? sensorId.hashCode() : 0;
        result = 31 * result + (frame != null ? frame.hashCode() : 0);
        return result;
    }
}
