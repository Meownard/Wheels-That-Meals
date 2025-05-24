package com.merrymeal.mealsonwheels_backend.dto;

import java.math.BigDecimal;

public class RegisterDTO {
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private String userType;  // e.g. "RIDER", "DONOR", etc.
    private String roleName;  // e.g. "ROLE_ADMIN", "ROLE_MEMBER"

    // Optional fields based on role

    // Member-specific
    private String address;
    private String dietaryRestriction;  // optional, can be null


    // Volunteer-specific
    private String availability;
    private String services;  // changed from qualificationsAndSkills

    // Rider-specific
    private String driverLicense;

    // Caregiver-specific
    private String qualificationAndSkills;

    // Partner-specific
    private String companyName;
    private String companyDes;
    private String companyAddress;  

    // Support-specific
    private String supportType;  // e.g., Volunteer, Advocate, Event Organizer
    private String supdescription;  // details about support offered

    // Donor-specific
    private String donorType;
    private BigDecimal donationAmount;

    public RegisterDTO() {}

    public RegisterDTO(String username, String phoneNumber, String email, String password,
                       String userType, String roleName) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.roleName = roleName;
    }

    // Getters and Setters

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getDietaryRestriction() { return dietaryRestriction; }
    public void setDietaryRestriction(String dietaryRestriction) { this.dietaryRestriction = dietaryRestriction; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }

    public String getServices() { return services; }
    public void setServices(String services) { this.services = services; }

    public String getDriverLicense() { return driverLicense; }
    public void setDriverLicense(String driverLicense) { this.driverLicense = driverLicense; }

    public String getQualificationAndSkills() { return qualificationAndSkills; }
    public void setQualificationAndSkills(String qualificationAndSkills) { this.qualificationAndSkills = qualificationAndSkills; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getCompanyDes() { return companyDes; }
    public void setCompanyDes(String companyDes) { this.companyDes = companyDes; }

    public String getCompanyAddress() { return companyAddress; }
    public void setCompanyAddress(String companyAddress) { this.companyAddress = companyAddress; }

    public String getSupportType() { return supportType; }
    public void setSupportType(String supportType) { this.supportType = supportType; }

    public String getSupdescription() { return supdescription; }
    public void setSupdescription(String supdescription) { this.supdescription = supdescription; }

    public String getDonorType() { return donorType; }
    public void setDonorType(String donorType) { this.donorType = donorType; }

    public BigDecimal getDonationAmount() { return donationAmount; }
    public void setDonationAmount(BigDecimal donationAmount) { this.donationAmount = donationAmount; }
}
