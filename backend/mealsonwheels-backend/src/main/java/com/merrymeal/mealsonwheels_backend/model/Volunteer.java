package com.merrymeal.mealsonwheels_backend.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("VOLUNTEER")
public class Volunteer extends User {

    @Column(nullable = false)
    private String availability; // e.g., "Weekdays", "Weekends", "Flexible"

    @Column(length = 255)
    private String services; // e.g., "Meal Packing, Delivery Assistance"

    public Volunteer() {
        super();
    }

    public Volunteer(String username, String phoneNumber, String email, String password,
                     boolean approved, Role role, String availability, String services) {
        super(username, phoneNumber, email, password, approved, role);
        this.availability = availability;
        this.services = services;
    }

    // Getters and setters
    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }

    public String getServices() { return services; }
    public void setServices(String services) { this.services = services; }
}
