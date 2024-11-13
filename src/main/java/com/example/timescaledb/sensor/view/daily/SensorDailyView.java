package com.example.timescaledb.sensor.view.daily;

import com.example.timescaledb.sensor.view.common.SensorDataView;
import jakarta.persistence.Entity;

import java.util.UUID;


@Entity(name = "sensor_daily")
public class SensorDailyView extends SensorDataView {

    public SensorDailyView() {
    }

    public SensorDailyView(UUID sensorId, String frame, double min, double max, double avg) {
        super(sensorId, frame, min, max, avg);
    }
}
