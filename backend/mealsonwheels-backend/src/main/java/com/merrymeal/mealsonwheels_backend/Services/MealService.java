package com.merrymeal.mealsonwheels_backend.Services;

import com.merrymeal.mealsonwheels_backend.Models.Meal;
import java.util.List;
import java.util.Optional;

public interface MealService {
    Meal saveMeal(Meal meal);
    List<Meal> getAllMeals();
    Optional<Meal> getMealById(Long id);
    Meal updateMeal(Long id, Meal meal);
    void deleteMeal(Long id);
}
