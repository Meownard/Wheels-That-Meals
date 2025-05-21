package com.merrymeal.mealsonwheels_backend.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SUPPORTER")
public class Supporter extends User {

    @Column(nullable = false)
    private String supportType;  // e.g., Volunteer, Advocate, Event Organizer

    @Column(length = 255)
    private String description;  // details about support offered

    public Supporter() {
        super();
    }

    public Supporter(String username, String phoneNumber, String email, String password,
                     boolean approved, Role role, String supportType, String description) {
        super(username, phoneNumber, email, password, approved, role);
        this.supportType = supportType;
        this.description = description;
    }

    public String getSupportType() {
        return supportType;
    }

    public void setSupportType(String supportType) {
        this.supportType = supportType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
