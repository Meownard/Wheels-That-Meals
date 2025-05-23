package com.merrymeal.mealsonwheels_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DishDTO {
    private Long id;

    @NotBlank(message = "Dish name is required")
    @Size(max = 100)
    private String dishName;

    @Size(max = 255)
    private String dishPhoto;

    @Size(max = 500)
    private String dishDesc;

    private Long mealId;

    private Long menuId;

    private String dishType;      // NEW

    private String dishDietary;   // NEW

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDishName() { return dishName; }
    public void setDishName(String dishName) { this.dishName = dishName; }

    public String getDishPhoto() { return dishPhoto; }
    public void setDishPhoto(String dishPhoto) { this.dishPhoto = dishPhoto; }

    public String getDishDesc() { return dishDesc; }
    public void setDishDesc(String dishDesc) { this.dishDesc = dishDesc; }

    public Long getMealId() { return mealId; }
    public void setMealId(Long mealId) { this.mealId = mealId; }

    public Long getMenuId() { return menuId; }
    public void setMenuId(Long menuId) { this.menuId = menuId; }

    public String getDishType() { return dishType; }
    public void setDishType(String dishType) { this.dishType = dishType; }

    public String getDishDietary() { return dishDietary; }
    public void setDishDietary(String dishDietary) { this.dishDietary = dishDietary; }
}
