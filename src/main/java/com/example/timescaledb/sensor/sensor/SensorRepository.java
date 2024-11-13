package com.example.timescaledb.sensor.sensor;

import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface SensorRepository extends ListCrudRepository<Sensor, UUID> {
}
