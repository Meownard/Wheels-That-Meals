package com.merrymeal.mealsonwheels_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MenuDTO {
    private Long id;

    @NotBlank(message = "Menu name is required")
    @Size(max = 100)
    private String menuName;

    @NotBlank(message = "Menu type is required")
    @Size(max = 50)
    private String menuType;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMenuName() { return menuName; }
    public void setMenuName(String menuName) { this.menuName = menuName; }

    public String getMenuType() { return menuType; }
    public void setMenuType(String menuType) { this.menuType = menuType; }
}
