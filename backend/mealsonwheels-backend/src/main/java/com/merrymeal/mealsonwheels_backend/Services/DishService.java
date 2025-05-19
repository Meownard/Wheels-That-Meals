package com.merrymeal.mealsonwheels_backend.Services;

import com.merrymeal.mealsonwheels_backend.Models.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {
    Dish saveDish(Dish dish);
    Optional<Dish> getDishById(Long id);
    List<Dish> getAllDishes();
    List<Dish> getDishesByMealId(Long mealId);
    List<Dish> getDishesByMenuId(Long menuId);
    Dish updateDish(Long id, Dish dishDetails);
    void deleteDish(Long id);
}
