package com.merrymeal.mealsonwheels_backend.service;

import com.merrymeal.mealsonwheels_backend.model.Menu;
import com.merrymeal.mealsonwheels_backend.repository.MenuRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements com.merrymeal.mealsonwheels_backend.service.MenuService {

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu updateMenu(Long id, Menu menuDetails) {
        return menuRepository.findById(id).map(menu -> {
            menu.setMenuName(menuDetails.getMenuName());
            menu.setMenuType(menuDetails.getMenuType());
            // If you want to update dishes list, handle here or in a separate method
            return menuRepository.save(menu);
        }).orElseThrow(() -> new RuntimeException("Menu not found with id " + id));
    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
