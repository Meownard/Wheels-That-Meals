package com.merrymeal.mealsonwheels_backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.merrymeal.mealsonwheels_backend.dto.DishDTO;
import com.merrymeal.mealsonwheels_backend.model.Dish;
import com.merrymeal.mealsonwheels_backend.model.Meal;
import com.merrymeal.mealsonwheels_backend.model.Menu;
import com.merrymeal.mealsonwheels_backend.service.DishService;
import com.merrymeal.mealsonwheels_backend.service.MealService;
import com.merrymeal.mealsonwheels_backend.service.MenuService;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private MealService mealService;

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<DishDTO> getAllDishes() {
        return dishService.getAllDishes().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DishDTO getDishById(@PathVariable Long id) {
        Dish dish = dishService.getDishById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found with id: " + id));
        return convertToDto(dish);
    }

    @PostMapping
    public DishDTO createDish(@Valid @RequestBody DishDTO dishDto) {
        Dish dish = convertToEntity(dishDto);
        Dish savedDish = dishService.saveDish(dish);
        return convertToDto(savedDish);
    }

    @PutMapping("/{id}")
    public DishDTO updateDish(@PathVariable Long id, @Valid @RequestBody DishDTO dishDto) {
        Dish dishDetails = convertToEntity(dishDto);
        Dish updatedDish = dishService.updateDish(id, dishDetails);
        return convertToDto(updatedDish);
    }

    @DeleteMapping("/{id}")
    public void deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
    }

    private DishDTO convertToDto(Dish dish) {
        DishDTO dto = new DishDTO();
        dto.setId(dish.getId());
        dto.setDishName(dish.getDishName());
        dto.setDishDesc(dish.getDescription());
        dto.setDishPhoto(dish.getPhoto());
        if (dish.getMeal() != null) {
            dto.setMealId(dish.getMeal().getId());
        }
        if (dish.getMenu() != null) {
            dto.setMenuId(dish.getMenu().getId());
        }
        return dto;
        }

        private Dish convertToEntity(DishDTO dto) {
        Dish dish = new Dish();
        dish.setDishName(dto.getDishName());
        dish.setDescription(dto.getDishDesc());
        dish.setPhoto(dto.getDishPhoto());
        if (dto.getMealId() != null) {
            Meal meal = mealService.getMealById(dto.getMealId())
                    .orElseThrow(() -> new RuntimeException("Meal not found with id: " + dto.getMealId()));
            dish.setMeal(meal);
        }
        if (dto.getMenuId() != null) {
            Menu menu = menuService.getMenuById(dto.getMenuId())
                    .orElseThrow(() -> new RuntimeException("Menu not found with id: " + dto.getMenuId()));
            dish.setMenu(menu);
        }
        return dish;
    }
}
