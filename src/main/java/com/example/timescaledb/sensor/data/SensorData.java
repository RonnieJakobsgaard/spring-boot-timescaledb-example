package com.example.timescaledb.sensor.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class SensorData {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID sensorId;
    private LocalDateTime time;
    private double value;

    public SensorData() {
    }

    public SensorData(UUID sensorId, LocalDateTime time, double value) {
        this.sensorId = sensorId;
        this.time = time;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSensorId() {
        return sensorId;
    }

    public void setSensorId(UUID sensorId) {
        this.sensorId = sensorId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
