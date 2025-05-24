package com.merrymeal.mealsonwheels_backend.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("SUPPORTER")
public class Supporter extends User {

    @Column(nullable = false)
    private String supportType;  // e.g., Volunteer, Advocate, Event Organizer

    @Column(length = 255)
    private String supdescription;  // details about support offered

    public Supporter() {
        super();
    }

    public Supporter(String username, String phoneNumber, String email, String password,
                     boolean approved, Role role, String supportType, String supdescription) {
        super(username, phoneNumber, email, password, approved, role);
        this.supportType = supportType;
        this.supdescription = supdescription;
    }

    public String getSupportType() {
        return supportType;
    }

    public void setSupportType(String supportType) {
        this.supportType = supportType;
    }

    public String getsupDescription() {
        return supdescription;
    }

    public void setsupDescription(String supdescription) {
        this.supdescription = supdescription;
    }
}
