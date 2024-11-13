package com.example.timescaledb.sensor.view.hourly;

import com.example.timescaledb.sensor.view.common.SensorDataView;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity(name = "sensor_hourly")
public class SensorHourlyView extends SensorDataView {

    public SensorHourlyView() {
    }

    public SensorHourlyView(UUID sensorId, String frame, double min, double max, double avg) {
        super(sensorId, frame, min, max, avg);
    }
}
