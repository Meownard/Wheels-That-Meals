package com.merrymeal.mealsonwheels_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class MealsonwheelsBackendApplication {

    private static final Logger logger = LoggerFactory.getLogger(MealsonwheelsBackendApplication.class);

    public static void main(String[] args) {
        logger.info("Starting application...");
        SpringApplication.run(MealsonwheelsBackendApplication.class, args);
        logger.info("Application finished running."); // This line will only print if the main thread continues after SpringApplication.run
    }

    @Bean
    ApplicationRunner simpleTest() {
        return _ -> { // Use args if you need them, otherwise just _ ->
            logger.info("✅ ApplicationRunner started its execution.");
            try {
                Thread.sleep(5000); // Wait 5 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupt status
                logger.error("ApplicationRunner sleep interrupted", e);
            }
            logger.info("✅ ApplicationRunner finished its execution after 5 seconds.");
        };
    }
}