package com.example.timescaledb;

import org.springframework.boot.SpringApplication;

public class TestTimescaledbExampleApplication {

	public static void main(String[] args) {
		SpringApplication.from(TimescaledbExampleApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
