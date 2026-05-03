package dev_practice.cinema_backend;

import org.springframework.boot.SpringApplication;
import org.testcontainers.utility.TestcontainersConfiguration;

public class TestCinemaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.from(CinemaBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}