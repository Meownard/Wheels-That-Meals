package com.merrymeal.mealsonwheels_backend.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.merrymeal.mealsonwheels_backend.Models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByMenuType(String menuType);
}
