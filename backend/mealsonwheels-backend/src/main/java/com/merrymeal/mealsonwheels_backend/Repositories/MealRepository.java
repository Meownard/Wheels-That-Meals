package com.merrymeal.mealsonwheels_backend.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.merrymeal.mealsonwheels_backend.Models.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByMenuId(Long menuId);
    List<Meal> findByPartnerId(Long partnerId);
}
