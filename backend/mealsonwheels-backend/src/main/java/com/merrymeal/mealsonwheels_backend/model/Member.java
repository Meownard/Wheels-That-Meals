package com.merrymeal.mealsonwheels_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("MEMBER")
public class Member extends User {

    @Column(nullable = true) // dietary restriction can be optional
    private String dietaryRestriction;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private double memberLocationLong;

    @Column(nullable = false)
    private double memberLocationLat;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caregiver_id")
    @JsonBackReference
    private Caregiver caregiver;

    public Member() {
        super();
    }

    public Member(String username, String phoneNumber, String email, String password,
                boolean approved, Role role, String dietaryRestriction,
                String address, double memberLocationLat, double memberLocationLong) {
        super(username, phoneNumber, email, password, approved, role);
        this.dietaryRestriction = dietaryRestriction;
        this.address = address;
        this.memberLocationLat = memberLocationLat;
        this.memberLocationLong = memberLocationLong;
    }


    // Getters and setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
public double getMemberLocationLat() { return memberLocationLat; }
public void setMemberLocationLat(double memberLocationLat) { this.memberLocationLat = memberLocationLat; }

public double getMemberLocationLong() { return memberLocationLong; }
public void setMemberLocationLong(double memberLocationLong) { this.memberLocationLong = memberLocationLong; }


    public String getDietaryRestriction() {
        return dietaryRestriction;
    }

    public void setDietaryRestriction(String dietaryRestriction) {
        this.dietaryRestriction = dietaryRestriction;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }
}
