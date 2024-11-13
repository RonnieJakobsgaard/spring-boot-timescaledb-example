package com.example.timescaledb.sensor.sensor;

import org.springframework.stereotype.Service;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public Sensor create(Sensor sensor) {
        return sensorRepository.save(sensor);
    }
}
