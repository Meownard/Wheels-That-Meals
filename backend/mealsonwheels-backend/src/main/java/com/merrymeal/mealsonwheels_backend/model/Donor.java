package com.merrymeal.mealsonwheels_backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("DONOR")
public class Donor extends User {

    private String donorType; // e.g., Individual, Corporate

    private BigDecimal totalDonatedAmount;

    public Donor() {
        super();
        this.totalDonatedAmount = BigDecimal.ZERO;
    }

    public Donor(String username, String phoneNumber, String email, String password,
            boolean approved, Role role, String donorType, BigDecimal totalDonatedAmount) {
        super(username, phoneNumber, email, password, approved, role);
        this.donorType = donorType;
        this.totalDonatedAmount = totalDonatedAmount;
    }

    public String getDonorType() {
        return donorType;
    }

    public void setDonorType(String donorType) {
        this.donorType = donorType;
    }

    public BigDecimal getTotalDonatedAmount() {
        return totalDonatedAmount;
    }

    public void setTotalDonatedAmount(BigDecimal totalDonatedAmount) {
        this.totalDonatedAmount = totalDonatedAmount;
    }

    public void addDonation(BigDecimal amount) {
        if (amount != null && amount.compareTo(BigDecimal.ZERO) > 0) {
            this.totalDonatedAmount = this.totalDonatedAmount.add(amount);
        }
    }
}
