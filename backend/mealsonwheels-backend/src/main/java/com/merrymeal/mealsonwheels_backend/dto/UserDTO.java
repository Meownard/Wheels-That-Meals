package com.merrymeal.mealsonwheels_backend.dto;

public class UserDTO {
    private Long id;
    private String username;
    private String phoneNumber;
    private String email;
    private String userType;
    private String roleName;
    private boolean approved;

    public UserDTO() {}

    public UserDTO(Long id, String username, String phoneNumber, String email, String userType, String roleName, boolean approved) {
        this.id = id;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userType = userType;
        this.roleName = roleName;
        this.approved = approved;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }

    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }
}
