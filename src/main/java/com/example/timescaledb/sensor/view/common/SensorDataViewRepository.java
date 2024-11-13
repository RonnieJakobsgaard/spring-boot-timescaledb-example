package com.example.timescaledb.sensor.view.common;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface SensorDataViewRepository<T extends SensorDataView> extends ListCrudRepository<T, UUID> {
}
