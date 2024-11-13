package com.example.timescaledb.sensor.data;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorDataService {

    private final SensorDataRepository sensorDataRepository;

    public SensorDataService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public SensorData create(SensorData sensorData) {
        return sensorDataRepository.save(sensorData);
    }
}
