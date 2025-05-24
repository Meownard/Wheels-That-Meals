package com.merrymeal.mealsonwheels_backend.controller; // Or appropriate package

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController { // Renamed from HomeController to avoid confusion if you already have one

    @GetMapping("/test") // Access via /test, not just /
    public String testEndpoint() {
        return "Application is responding!";
    }
}