package com.example.timescaledb.sensor.view.hourly;

import com.example.timescaledb.sensor.view.common.SensorDataViewRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SensorHourlyViewRepository extends SensorDataViewRepository<SensorHourlyView> {

    @Query(value = "SELECT * FROM sensor_hourly t WHERE t.sensor_id = :sensorId", nativeQuery = true)
    List<SensorHourlyView> findBySensorId(UUID sensorId);
}
