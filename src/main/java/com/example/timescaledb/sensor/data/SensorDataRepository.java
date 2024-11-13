package com.example.timescaledb.sensor.data;

import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface SensorDataRepository extends ListCrudRepository<SensorData, UUID> {
}
