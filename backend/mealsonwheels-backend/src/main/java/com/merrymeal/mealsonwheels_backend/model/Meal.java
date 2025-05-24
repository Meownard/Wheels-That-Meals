package com.merrymeal.mealsonwheels_backend.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mealName;

    private String mealPhoto;

    private String mealDesc;

    private String mealType;       // e.g., Breakfast, Lunch, Dinner
    private String mealDietary;    // e.g., Vegetarian, Gluten-Free

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dish> dishes = new ArrayList<>();

    // Constructors
    public Meal() {}

    public Meal(String mealName, String mealPhoto, String mealDesc, String mealType, String mealDietary, Menu menu) {
        this.mealName = mealName;
        this.mealPhoto = mealPhoto;
        this.mealDesc = mealDesc;
        this.mealType = mealType;
        this.mealDietary = mealDietary;
        this.menu = menu;
    }

    // Getters and Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getMealName() { return mealName; }

    public void setMealName(String mealName) { this.mealName = mealName; }

    public String getMealPhoto() { return mealPhoto; }

    public void setMealPhoto(String mealPhoto) { this.mealPhoto = mealPhoto; }

    public String getMealDesc() { return mealDesc; }

    public void setMealDesc(String mealDesc) { this.mealDesc = mealDesc; }

    public String getMealType() { return mealType; }

    public void setMealType(String mealType) { this.mealType = mealType; }

    public String getMealDietary() { return mealDietary; }

    public void setMealDietary(String mealDietary) { this.mealDietary = mealDietary; }

    public Partner getPartner() { return partner; }

    public void setPartner(Partner partner) { this.partner = partner; }

    public Menu getMenu() { return menu; }

    public void setMenu(Menu menu) { this.menu = menu; }

    public List<Dish> getDishes() { return dishes; }

    public void setDishes(List<Dish> dishes) { this.dishes = dishes; }

    // equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meal)) return false;
        Meal meal = (Meal) o;
        return Objects.equals(id, meal.id) &&
               Objects.equals(mealName, meal.mealName) &&
               Objects.equals(menu, meal.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mealName, menu);
    }

    // toString

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", mealName='" + mealName + '\'' +
                ", mealPhoto='" + mealPhoto + '\'' +
                ", mealDesc='" + mealDesc + '\'' +
                ", mealType='" + mealType + '\'' +
                ", mealDietary='" + mealDietary + '\'' +
                ", menu=" + (menu != null ? menu.getId() : "null") +
                '}';
    }
}
