package com.merrymeal.mealsonwheels_backend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@DiscriminatorValue("RIDER")
public class Rider extends User {

    private String driverLicenseNumber;

    @OneToMany(mappedBy = "rider", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Order> deliveredOrders;

    public Rider() {
        super();
    }

    public Rider(String username, String phoneNumber, String email, String password,
                 boolean approved, Role role, String driverLicenseNumber) {
        super(username, phoneNumber, email, password, approved, role);
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public List<Order> getDeliveredOrders() {
        return deliveredOrders;
    }

    public void setDeliveredOrders(List<Order> deliveredOrders) {
        this.deliveredOrders = deliveredOrders;
    }
}
