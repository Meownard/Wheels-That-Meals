package com.merrymeal.mealsonwheels_backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("CAREGIVER")
public class Caregiver extends User {

    @Column(length = 500)
    private String qualificationsAndSkills;

    @OneToMany(mappedBy = "caregiver", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Member> membersUnderCare = new ArrayList<>();

    public Caregiver() {
        super();
    }

    public Caregiver(String username, String phoneNumber, String email, String password,
                     boolean approved, Role role, String qualificationsAndSkills) {
        super(username, phoneNumber, email, password, approved, role);
        this.qualificationsAndSkills = qualificationsAndSkills;
    }

    // Getters and setters
    public String getQualificationsAndSkills() { return qualificationsAndSkills; }
    public void setQualificationsAndSkills(String qualificationsAndSkills) { this.qualificationsAndSkills = qualificationsAndSkills; }

    public List<Member> getMembersUnderCare() { return membersUnderCare; }
    public void setMembersUnderCare(List<Member> membersUnderCare) { this.membersUnderCare = membersUnderCare; }
}
