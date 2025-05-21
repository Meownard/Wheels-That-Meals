package com.merrymeal.mealsonwheels_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("MEMBER")
public class Member extends User {

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String location;

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
                  boolean approved, Role role, String address, String location) {
        super(username, phoneNumber, email, password, approved, role);
        this.address = address;
        this.location = location;
    }

    // Getters and setters
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }

    public Caregiver getCaregiver() { return caregiver; }
    public void setCaregiver(Caregiver caregiver) { this.caregiver = caregiver; }
}
