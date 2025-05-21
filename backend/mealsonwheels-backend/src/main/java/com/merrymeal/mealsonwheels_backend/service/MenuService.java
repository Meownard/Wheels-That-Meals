package com.merrymeal.mealsonwheels_backend.service;

import java.util.List;
import java.util.Optional;

import com.merrymeal.mealsonwheels_backend.model.Menu;

public interface MenuService {
    Menu saveMenu(Menu menu);
    Optional<Menu> getMenuById(Long id);
    List<Menu> getAllMenus();
    Menu updateMenu(Long id, Menu menuDetails);
    void deleteMenu(Long id);
}
