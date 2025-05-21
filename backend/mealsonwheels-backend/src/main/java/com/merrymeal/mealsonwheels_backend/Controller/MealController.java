package com.merrymeal.mealsonwheels_backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.merrymeal.mealsonwheels_backend.dto.MealDTO;
import com.merrymeal.mealsonwheels_backend.model.Meal;
import com.merrymeal.mealsonwheels_backend.model.Partner;
import com.merrymeal.mealsonwheels_backend.model.Menu;
import com.merrymeal.mealsonwheels_backend.service.MealService;
import com.merrymeal.mealsonwheels_backend.service.PartnerService;
import com.merrymeal.mealsonwheels_backend.service.MenuService;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<MealDTO> getAllMeals() {
        return mealService.getAllMeals().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MealDTO getMealById(@PathVariable Long id) {
        Meal meal = mealService.getMealById(id);
        return convertToDto(meal);
    }

    @PostMapping
    public MealDTO createMeal(@Valid @RequestBody MealDTO mealDto) {
        Meal meal = convertToEntity(mealDto);
        Meal savedMeal = mealService.saveMeal(meal);
        return convertToDto(savedMeal);
    }

    @PutMapping("/{id}")
    public MealDTO updateMeal(@PathVariable Long id, @Valid @RequestBody MealDTO mealDto) {
        Meal mealDetails = convertToEntity(mealDto);
        Meal updatedMeal = mealService.updateMeal(id, mealDetails);
        return convertToDto(updatedMeal);
    }

    @DeleteMapping("/{id}")
    public void deleteMeal(@PathVariable Long id) {
        mealService.deleteMeal(id);
    }

    private MealDTO convertToDto(Meal meal) {
        MealDTO dto = new MealDTO();
        dto.setId(meal.getId());
        dto.setMealName(meal.getMealName());
        dto.setMealDesc(meal.getMealDesc());
        dto.setMealPhoto(meal.getMealPhoto());
        if(meal.getPartner() != null) {
            dto.setPartnerId(meal.getPartner().getId());
        }
        if(meal.getMenu() != null) {
            dto.setMenuId(meal.getMenu().getId());
        }
        return dto;
    }

    private Meal convertToEntity(MealDTO dto) {
        Meal meal = new Meal();
        meal.setMealName(dto.getMealName());
        meal.setMealDesc(dto.getMealDesc());
        meal.setMealPhoto(dto.getMealPhoto());

        if (dto.getPartnerId() != null) {
            Partner partner = partnerService.getPartnerById(dto.getPartnerId());
            meal.setPartner(partner);
        }
        if (dto.getMenuId() != null) {
            Menu menu = menuService.getMenuById(dto.getMenuId());
            meal.setMenu(menu);
        }
        return meal;
    }
}
