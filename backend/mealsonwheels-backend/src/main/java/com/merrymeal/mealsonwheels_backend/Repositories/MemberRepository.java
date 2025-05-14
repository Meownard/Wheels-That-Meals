package com.merrymeal.mealsonwheels_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.merrymeal.mealsonwheels_backend.Models.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
