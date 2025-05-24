package com.merrymeal.mealsonwheels_backend.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dishName;

    private String dishDesc;

    private String photo;

    private Integer quantity;

    private String dishType;       // e.g., Main, Side, Dessert
    private String dishDietary;    // e.g., Vegan, Nut-Free

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    // Constructors
    public Dish() {}

    public Dish(String dishName, String dishDesc, Integer quantity, String dishType, String dishDietary) {
        this.dishName = dishName;
        this.dishDesc = dishDesc;
        this.quantity = quantity;
        this.dishType = dishType;
        this.dishDietary = dishDietary;
    }

    // Getters and Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDishName() { return dishName; }

    public void setDishName(String dishName) { this.dishName = dishName; }

    public String getDishDesc() { return dishDesc; }

    public void setDishDesc(String dishDesc) { this.dishDesc = dishDesc; }

    public String getPhoto() { return photo; }

    public void setPhoto(String photo) { this.photo = photo; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getDishType() { return dishType; }

    public void setDishType(String dishType) { this.dishType = dishType; }

    public String getDishDietary() { return dishDietary; }

    public void setDishDietary(String dishDietary) { this.dishDietary = dishDietary; }

    public Meal getMeal() { return meal; }

    public void setMeal(Meal meal) { this.meal = meal; }

    public Menu getMenu() { return menu; }

    public void setMenu(Menu menu) { this.menu = menu; }

    // equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return Objects.equals(id, dish.id) &&
               Objects.equals(dishName, dish.dishName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dishName);
    }

    // toString

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", dishDesc='" + dishDesc + '\'' +
                ", dishType='" + dishType + '\'' +
                ", dishDietary='" + dishDietary + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
