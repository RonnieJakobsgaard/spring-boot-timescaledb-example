package com.example.timescaledb.sensor.view;


import com.example.timescaledb.TestcontainersConfiguration;
import com.example.timescaledb.helpers.TestDataCreatorHelper;
import com.example.timescaledb.sensor.data.SensorData;
import com.example.timescaledb.sensor.data.SensorDataService;
import com.example.timescaledb.sensor.sensor.SensorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;


@Import(TestcontainersConfiguration.class)
@SpringBootTest
public class TestSensorViewService {

    @Autowired
    private SensorViewService sensorViewService;

    @Autowired
    private SensorDataService sensorDataService;

    @Autowired
    private SensorService sensorService;

    private TestDataCreatorHelper testDataCreatorHelper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setup() {
        testDataCreatorHelper = new TestDataCreatorHelper(sensorService, sensorDataService);
    }

    @Test
    public void insert_data_with_materialized_only_false() throws Exception {
        var sensor = testDataCreatorHelper.createSensor();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        var sensorData1 = sensorDataService.create(new SensorData(sensor.getId(), yesterday.atStartOfDay(), 11.11));
        var sensorData11 = sensorDataService.create(new SensorData(sensor.getId(), yesterday.atStartOfDay(), 33.33));

        LocalDate today = LocalDate.now();
        var sensorData2 = sensorDataService.create(new SensorData(sensor.getId(), today.atStartOfDay(), 22.22));

        var views1 = sensorViewService.findBySensorId(sensor.getId(), Interval.DAILY); // Daily has materialized_only = false

        // From two different days
        Assertions.assertEquals(2, views1.size());
    }

    @Test
    public void insert_data_with_materialized_only_true() throws Exception {
        var sensor = testDataCreatorHelper.createSensor();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        var sensorData1 = sensorDataService.create(new SensorData(sensor.getId(), yesterday.atStartOfDay(), 11.11));
        var sensorData11 = sensorDataService.create(new SensorData(sensor.getId(), yesterday.atStartOfDay(), 33.33));

        LocalDate today = LocalDate.now();

        jdbcTemplate.execute("CALL refresh_continuous_aggregate('sensor_hourly', NULL, NULL)");

        var sensorData2 = sensorDataService.create(new SensorData(sensor.getId(), today.atStartOfDay(), 22.22));

        var views1 = sensorViewService.findBySensorId(sensor.getId(), Interval.HOURLY); // Hourly has materialized_only = true (default)
        Assertions.assertEquals(1, views1.size()); // Only once view here since the last insert is not materialized

        jdbcTemplate.execute("CALL refresh_continuous_aggregate('sensor_hourly', NULL, NULL)");

        var views2 = sensorViewService.findBySensorId(sensor.getId(), Interval.HOURLY); // Hourly has materialized_only = true (default)
        Assertions.assertEquals(2, views2.size()); // Now we have two views since the last insert is materialized
    }
}
