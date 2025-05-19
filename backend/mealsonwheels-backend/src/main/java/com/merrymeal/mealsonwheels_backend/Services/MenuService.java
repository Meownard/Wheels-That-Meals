package com.merrymeal.mealsonwheels_backend.Services;

import com.merrymeal.mealsonwheels_backend.Models.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    Menu saveMenu(Menu menu);
    Optional<Menu> getMenuById(Long id);
    List<Menu> getAllMenus();
    Menu updateMenu(Long id, Menu menuDetails);
    void deleteMenu(Long id);
}
