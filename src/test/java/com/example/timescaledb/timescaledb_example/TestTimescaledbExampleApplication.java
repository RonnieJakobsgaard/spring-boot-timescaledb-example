package com.example.timescaledb.timescaledb_example;

import org.springframework.boot.SpringApplication;

public class TestTimescaledbExampleApplication {

	public static void main(String[] args) {
		SpringApplication.from(TimescaledbExampleApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
