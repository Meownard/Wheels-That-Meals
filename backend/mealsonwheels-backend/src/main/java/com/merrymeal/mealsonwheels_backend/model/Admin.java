package com.merrymeal.mealsonwheels_backend.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(String username, String phoneNumber, String email, String password, boolean approved, Role role) {
        super(username, phoneNumber, email, password, approved, role);
    }
}
