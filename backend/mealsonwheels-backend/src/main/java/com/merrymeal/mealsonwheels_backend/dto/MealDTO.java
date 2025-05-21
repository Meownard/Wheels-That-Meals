package com.merrymeal.mealsonwheels_backend.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MealDTO {
    private Long id;

    @NotBlank(message = "Meal name is required")
    @Size(max = 100)
    private String mealName;

    @Size(max = 255)
    private String mealPhoto;

    @Size(max = 500)
    private String mealDesc;

    private Long partnerId;

    private Long menuId;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMealName() { return mealName; }
    public void setMealName(String mealName) { this.mealName = mealName; }

    public String getMealPhoto() { return mealPhoto; }
    public void setMealPhoto(String mealPhoto) { this.mealPhoto = mealPhoto; }

    public String getMealDesc() { return mealDesc; }
    public void setMealDesc(String mealDesc) { this.mealDesc = mealDesc; }

    public Long getPartnerId() { return partnerId; }
    public void setPartnerId(Long partnerId) { this.partnerId = partnerId; }

    public Long getMenuId() { return menuId; }
    public void setMenuId(Long menuId) { this.menuId = menuId; }
}
