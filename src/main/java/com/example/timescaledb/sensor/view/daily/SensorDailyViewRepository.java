package com.example.timescaledb.sensor.view.daily;

import com.example.timescaledb.sensor.view.common.SensorDataViewRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SensorDailyViewRepository extends SensorDataViewRepository<SensorDailyView> {

    @Query(value = "SELECT * FROM sensor_daily t WHERE t.sensor_id = :sensorId", nativeQuery = true)
    List<SensorDailyView> findBySensorId(UUID sensorId);
}
