package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Menu;
import com.example.demo.repository.MenuRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAllMenuItems() {
        List<Menu> items = new ArrayList<>();
        menuRepository.findAll().forEach(items::add);
        return items;
    }

    public Menu getMenuItemById(int id) {
        return menuRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Menu menu) {
        menuRepository.save(menu);
    }

    public void delete(int id) {
        menuRepository.deleteById(id);
    }
}
