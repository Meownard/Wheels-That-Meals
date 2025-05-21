package com.merrymeal.mealsonwheels_backend.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("PARTNER")
public class Partner extends User {

    private String organizationName;
    private String description;
    private String address;

    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Meal> providedMeals = new ArrayList<>();

    public Partner() {
        super();
    }

    public Partner(String username, String phoneNumber, String email, String password,
                   boolean approved, Role role, String organizationName, String description, String address) {
        super(username, phoneNumber, email, password, approved, role);
        this.organizationName = organizationName;
        this.description = description;
        this.address = address;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Meal> getProvidedMeals() {
        return providedMeals;
    }

    public void setProvidedMeals(List<Meal> providedMeals) {
        this.providedMeals = providedMeals;
    }
}
