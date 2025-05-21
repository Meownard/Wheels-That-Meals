package com.merrymeal.mealsonwheels_backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.merrymeal.mealsonwheels_backend.dto.MenuDTO;
import com.merrymeal.mealsonwheels_backend.model.Menu;
import com.merrymeal.mealsonwheels_backend.service.MenuService;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<MenuDTO> getAllMenus() {
        return menuService.getAllMenus().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MenuDTO getMenuById(@PathVariable Long id) {
        Menu menu = menuService.getMenuById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + id));
        return convertToDto(menu);
    }

    @PostMapping
    public MenuDTO createMenu(@Valid @RequestBody MenuDTO menuDto) {
        Menu menu = convertToEntity(menuDto);
        Menu savedMenu = menuService.saveMenu(menu);
        return convertToDto(savedMenu);
    }

    @PutMapping("/{id}")
    public MenuDTO updateMenu(@PathVariable Long id, @Valid @RequestBody MenuDTO menuDto) {
        Menu menuDetails = convertToEntity(menuDto);
        Menu updatedMenu = menuService.updateMenu(id, menuDetails);
        return convertToDto(updatedMenu);
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }

    private MenuDTO convertToDto(Menu menu) {
        MenuDTO dto = new MenuDTO();
        dto.setId(menu.getId());
        dto.setMenuName(menu.getMenuName());
        dto.setMenuType(menu.getMenuType());
        return dto;
    }

    private Menu convertToEntity(MenuDTO dto) {
        Menu menu = new Menu();
        menu.setMenuName(dto.getMenuName());
        menu.setMenuType(dto.getMenuType());
        return menu;
    }
}
