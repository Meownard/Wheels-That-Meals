package com.merrymeal.mealsonwheels_backend.Models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@DiscriminatorValue("CAREGIVER")
public class Caregiver extends User {
    
    private String qualificationsAndSkills;

    @OneToMany(mappedBy = "caregiver", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Member> membersUnderCare;

    public String getQualificationsAndSkills() {
        return qualificationsAndSkills;
    }

    public void setQualificationsAndSkills(String qualificationsAndSkills) {
        this.qualificationsAndSkills = qualificationsAndSkills;
    }

    public List<Member> getMembersUnderCare() {
        return membersUnderCare;
    }

    public void setMembersUnderCare(List<Member> membersUnderCare) {
        this.membersUnderCare = membersUnderCare;
    }
}
