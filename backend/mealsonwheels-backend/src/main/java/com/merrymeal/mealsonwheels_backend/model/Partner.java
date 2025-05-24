package com.merrymeal.mealsonwheels_backend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("PARTNER")
public class Partner extends User {

    private String companyName;
    private String companyDes;
    private String companyAddress;
    
    // Change these from String to double for proper coordinates handling
    private double companyLocationLat;
    private double companyLocationLong;

    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Meal> providedMeals = new ArrayList<>();

    public Partner() {
        super();
    }

    public Partner(String username, String phoneNumber, String email, String password,
                   boolean approved, Role role, String companyName, String companyDes, 
                   String companyAddress, double companyLocationLat, double companyLocationLong) {
        super(username, phoneNumber, email, password, approved, role);
        this.companyName = companyName;
        this.companyDes = companyDes;
        this.companyAddress = companyAddress;
        this.companyLocationLat = companyLocationLat;
        this.companyLocationLong = companyLocationLong;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDes() {
        return companyDes;
    }

    public void setCompanyDes(String companyDes) {
        this.companyDes = companyDes;
    }

    public double getCompanyLocationLat() {
        return companyLocationLat;
    }

    public void setCompanyLocationLat(double companyLocationLat) {
        this.companyLocationLat = companyLocationLat;
    }

    public double getCompanyLocationLong() {
        return companyLocationLong;
    }

    public void setCompanyLocationLong(double companyLocationLong) {
        this.companyLocationLong = companyLocationLong;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public List<Meal> getProvidedMeals() {
        return providedMeals;
    }

    public void setProvidedMeals(List<Meal> providedMeals) {
        this.providedMeals = providedMeals;
    }
}
