package com.example.timescaledb;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainersConfiguration {

	@Bean
	@ServiceConnection
	PostgreSQLContainer<?> timescaledb() {
		return new PostgreSQLContainer<>(
				DockerImageName.parse("timescale/timescaledb:latest-pg17")
						.asCompatibleSubstituteFor("postgres"));
	}

}
