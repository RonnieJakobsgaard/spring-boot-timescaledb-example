package com.example.timescaledb.helpers;

import com.example.timescaledb.sensor.data.SensorData;
import com.example.timescaledb.sensor.data.SensorDataService;
import com.example.timescaledb.sensor.sensor.Sensor;
import com.example.timescaledb.sensor.sensor.SensorService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class TestDataCreatorHelper {

    private final SensorService sensorService;
    private final SensorDataService sensorDataService;

    public TestDataCreatorHelper(SensorService sensorService, SensorDataService sensorDataService) {
        this.sensorService = sensorService;
        this.sensorDataService = sensorDataService;
    }

    public Sensor createSensor() {
        return sensorService.create(new Sensor("sensor1"));
    }

    public void createSensorData(UUID sensorId, long years, long months, long days) {
        LocalDate today = LocalDate.now();
        LocalDate from = today.minusYears(years).minusMonths(months).minusDays(days);

        long daysBetween = from.datesUntil(today).count();

        for(int i = 0; i < daysBetween; i++) {
            LocalDate currentDate = from.plusDays(i);

            for(int j = 0; j < 4; j++) {
                LocalDateTime currentDateTime = currentDate.atStartOfDay().plusHours(j * 6);
                var sensorData = new SensorData(sensorId, currentDateTime, 1.11);
                sensorDataService.create(sensorData);
            }
        }
    }
}
