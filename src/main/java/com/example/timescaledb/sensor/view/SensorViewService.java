package com.example.timescaledb.sensor.view;

import com.example.timescaledb.sensor.view.common.SensorDataView;
import com.example.timescaledb.sensor.view.daily.SensorDailyView;
import com.example.timescaledb.sensor.view.daily.SensorDailyViewRepository;
import com.example.timescaledb.sensor.view.hourly.SensorHourlyView;
import com.example.timescaledb.sensor.view.hourly.SensorHourlyViewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SensorViewService {

    private final SensorDailyViewRepository sensorDailyRepository;
    private final SensorHourlyViewRepository sensorHourlyRepository;

    public SensorViewService(SensorDailyViewRepository sensorDailyRepository, SensorHourlyViewRepository sensorHourlyRepository) {
        this.sensorDailyRepository = sensorDailyRepository;
        this.sensorHourlyRepository = sensorHourlyRepository;
    }

    public List<SensorDataView> findBySensorId(UUID sensorId, Interval interval) throws Exception {
        return switch (interval) {
            case HOURLY -> mapToSensorDataViewFromHourly(sensorHourlyRepository.findBySensorId(sensorId));
            case DAILY -> mapToSensorDataViewFromDaily(sensorDailyRepository.findBySensorId(sensorId));
        };
    }

    private List<SensorDataView> mapToSensorDataViewFromDaily(List<SensorDailyView> sensorDailyViews) {
        return sensorDailyViews.stream()
                .map(sensorDailyView -> new SensorDataView(
                        sensorDailyView.getSensorId(),
                        sensorDailyView.getFrame(),
                        sensorDailyView.getMin(),
                        sensorDailyView.getMax(),
                        sensorDailyView.getAvg()))
                .toList();
    }

    private List<SensorDataView> mapToSensorDataViewFromHourly(List<SensorHourlyView> sensorHourlyViews) {
        return sensorHourlyViews.stream()
                .map(sensorHourlyView -> new SensorDataView(
                        sensorHourlyView.getSensorId(),
                        sensorHourlyView.getFrame(),
                        sensorHourlyView.getMin(),
                        sensorHourlyView.getMax(),
                        sensorHourlyView.getAvg()))
                .toList();
    }
}
