package com.merrymeal.mealsonwheels_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan // ✅ This is important
public class MealsonwheelsBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(MealsonwheelsBackendApplication.class, args);
    }
}
