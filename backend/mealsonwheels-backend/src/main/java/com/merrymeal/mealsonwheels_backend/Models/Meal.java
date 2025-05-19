package com.merrymeal.mealsonwheels_backend.Models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mealName;
    private String mealPhoto;
    private String mealDesc;
    
    @ManyToOne
    @JoinColumn(name = "partner_id")
    @JsonManagedReference
    private Partner partner;
    
    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Dish> dishes = new ArrayList<>();

    // Constructors
    public Meal() {
    }

    public Meal(String mealName, String mealDesc, String mealPhoto) {
        this.mealName = mealName;
        this.mealDesc = mealDesc;
        this.mealPhoto = mealPhoto;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealPhoto() {
        return mealPhoto;
    }

    public void setMealPhoto(String mealPhoto) {
        this.mealPhoto = mealPhoto;
    }

    public String getMealDesc() {
        return mealDesc;
    }

    public void setMealDesc(String mealDesc) {
        this.mealDesc = mealDesc;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
        dish.setMeal(this);
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
        dish.setMeal(null);
    }
}
