CREATE TABLE sensor
(
    id          UUID NOT NULL,
    name        TEXT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE sensor_data
(
    id        UUID NOT NULL,
    sensor_id UUID NOT NULL,
    time      TIMESTAMPTZ NOT NULL,
    value     DECIMAL(19, 2),
    CONSTRAINT fk_sensor_data_sensor_id FOREIGN KEY (sensor_id) REFERENCES sensor(id)
);

SELECT create_hypertable('sensor_data', 'time');