package com.example.demo.Controller;

import com.example.demo.Model.Menu;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/home")
    public String showHomePage(Model model) {
        List<Menu> menuItems = menuService.getAllMenuItems();
        model.addAttribute("menuItems", menuItems);
        return "home";
    }
}
