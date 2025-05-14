package com.merrymeal.mealsonwheels_backend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.merrymeal.mealsonwheels_backend.Models.Member;
import com.merrymeal.mealsonwheels_backend.Repositories.MemberRepository;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        return memberRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member memberDetails) {
        return memberRepository.findById(id).map(member -> {
            member.setName(memberDetails.getName());
            member.setAddress(memberDetails.getAddress());
            member.setContactDetails(memberDetails.getContactDetails());
            member.setDietaryRestrictions(memberDetails.getDietaryRestrictions());
            return ResponseEntity.ok(memberRepository.save(member));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMember(@PathVariable Long id) {
        return memberRepository.findById(id).map(member -> {
            memberRepository.delete(member);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

