CREATE MATERIALIZED VIEW sensor_daily
WITH (timescaledb.continuous, timescaledb.materialized_only = false) AS
SELECT
    time_bucket('1 day', time) as frame,
    sensor_id,
    max(value) as max,
    min(value) as min,
    avg(value) as avg
FROM sensor_data
GROUP BY frame, sensor_id
ORDER BY frame DESC;

CREATE MATERIALIZED VIEW sensor_hourly
WITH (timescaledb.continuous) AS
SELECT
    time_bucket('1 hour', time) as frame,
    sensor_id,
    max(value) as max,
    min(value) as min,
    avg(value) as avg
FROM sensor_data
GROUP BY frame, sensor_id
ORDER BY frame DESC;
