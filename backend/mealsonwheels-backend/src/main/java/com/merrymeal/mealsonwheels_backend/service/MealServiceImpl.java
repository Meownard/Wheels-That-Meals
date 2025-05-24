package com.merrymeal.mealsonwheels_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.merrymeal.mealsonwheels_backend.exception.ResourceNotFoundException;
import com.merrymeal.mealsonwheels_backend.model.Meal;
import com.merrymeal.mealsonwheels_backend.repository.MealRepository;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Meal saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    @Override
    public Optional<Meal> getMealById(Long id) {
        return mealRepository.findById(id);
    }

    @Override
    public Meal updateMeal(Long id, Meal mealDetails) {
        Meal meal = mealRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meal not found with id " + id));
        meal.setMealName(mealDetails.getMealName());
        meal.setMealDesc(mealDetails.getMealDesc());
        meal.setMealPhoto(mealDetails.getMealPhoto());
        meal.setPartner(mealDetails.getPartner());
        meal.setMealType(mealDetails.getMealType());        // NEW
        meal.setMealDietary(mealDetails.getMealDietary());  // NEW
        return mealRepository.save(meal);
    }

    @Override
    public void deleteMeal(Long id) {
        Meal meal = mealRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meal not found with id " + id));
        mealRepository.delete(meal);
    }
}
