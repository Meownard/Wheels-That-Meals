package com.merrymeal.mealsonwheels_backend.service;

import com.merrymeal.mealsonwheels_backend.model.Dish;
import com.merrymeal.mealsonwheels_backend.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish saveDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Optional<Dish> getDishById(Long id) {
        return dishRepository.findById(id);
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    public List<Dish> getDishesByMealId(Long mealId) {
        return dishRepository.findByMealId(mealId);
    }

    @Override
    public List<Dish> getDishesByMenuId(Long menuId) {
        return dishRepository.findByMenuId(menuId);
    }

    @Override
    public Dish updateDish(Long id, Dish dishDetails) {
        return dishRepository.findById(id).map(dish -> {
            dish.setDishName(dishDetails.getDishName());
            dish.setDishDesc(dishDetails.getDishDesc()); // Corrected this line
            dish.setPhoto(dishDetails.getPhoto());
            dish.setQuantity(dishDetails.getQuantity());
            dish.setDishType(dishDetails.getDishType());           // Added new field
            dish.setDishDietary(dishDetails.getDishDietary());     // Added new field
            dish.setMeal(dishDetails.getMeal());
            dish.setMenu(dishDetails.getMenu());
            return dishRepository.save(dish);
        }).orElseThrow(() -> new RuntimeException("Dish not found with id " + id));
    }

    @Override
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
}
