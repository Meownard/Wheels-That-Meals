package com.merrymeal.mealsonwheels_backend.dto;

public class RegisterDTO {
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private String userType;  // e.g. "RIDER", "DONOR", etc.
    private String roleName;  // e.g. "ROLE_ADMIN", "ROLE_MEMBER"

    public RegisterDTO() {}

    public RegisterDTO(String username, String phoneNumber, String email, String password, String userType, String roleName) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.roleName = roleName;
    }

    // Getters and setters
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
}
