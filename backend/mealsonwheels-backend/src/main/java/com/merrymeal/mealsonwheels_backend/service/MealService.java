package com.merrymeal.mealsonwheels_backend.service;

import java.util.List;
import java.util.Optional;

import com.merrymeal.mealsonwheels_backend.model.Meal;

public interface MealService {
    Meal saveMeal(Meal meal);
    List<Meal> getAllMeals();
    Optional<Meal> getMealById(Long id);
    Meal updateMeal(Long id, Meal meal);
    void deleteMeal(Long id);
}
