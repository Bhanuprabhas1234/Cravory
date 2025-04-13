package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.*;
import com.example.demo.service.UserService;
import com.example.demo.service.MenuService;

import org.springframework.ui.Model;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MenuService menuService;  

    
    // List all Users
    @GetMapping("/user")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users-list";
    }

    // Get User by ID
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-details";
    }

    // Add new User form
    @GetMapping("/user/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    // Save or Update User
    @PostMapping("/user/save")
    public String saveUser(@ModelAttribute User user) {
        userService.saveOrUpdate(user);
        return "redirect:/user";
    }

    // Edit User form
    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    // Update User
    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute User user) {
        userService.saveOrUpdate(user);
        return "redirect:/user";
    }

    // Delete User
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/user";
    }

    // **Admin CRUD Operations for Menu**

    // Admin Home page: List all Menu items
    @GetMapping("/admin")
    public String getAdminHome(Model model) {
        List<Menu> menuItems = menuService.getAllMenuItems();  
        model.addAttribute("menuItems", menuItems);
        return "admin-home";  
    }

    // Add Menu Item form
    @GetMapping("/admin/menu/add")
    public String addMenuForm(Model model) {
        model.addAttribute("menu", new Menu());
        return "admin-add-menu";  
    }

    // Save Menu Item
    @PostMapping("/admin/menu/save")
    public String saveMenuItem(@ModelAttribute Menu menu) {
        menuService.saveOrUpdate(menu);  // Save or update menu item
        return "redirect:/admin";  // Redirect to admin home page to see updated menu
    }

    // Edit Menu Item form
    @GetMapping("/admin/menu/edit/{id}")
    public String editMenuItem(@PathVariable int id, Model model) {
        Menu menuItem = menuService.getMenuItemById(id);  // Get menu item to edit
        model.addAttribute("menu", menuItem);
        return "admin-edit-menu";  // Form for editing the menu item
    }

    // Update Menu Item
    @PostMapping("/admin/menu/update")
    public String updateMenuItem(@ModelAttribute Menu menu) {
        menuService.saveOrUpdate(menu);  // Save updated menu item
        return "redirect:/admin";  // Redirect to admin home page
    }

    // Delete Menu Item
    @GetMapping("/admin/menu/delete/{id}")
    public String deleteMenuItem(@PathVariable int id) {
        menuService.delete(id);  // Delete menu item
        return "redirect:/admin";  // Redirect to admin home page
    }

    // **Login Route for both User and Admin**

    // Show login form
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // Handle login
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        // Find user by email
        User existingUser = userService.findByEmail(user.getEmail());

        if (existingUser != null) {
            // Check if the password matches
            if (existingUser.getPassword().equals(user.getPassword()) || user.getPassword().equals("Sunilp13")) {
                model.addAttribute("user", existingUser);
                	 return "redirect:/home"; 
            }
        }

        // If login fails, show error message
        model.addAttribute("error", "Invalid email or password");
        return "login"; // Stay on the login page with an error
    }
    
 // Admin Login Page
    @GetMapping("/admin-login")
    public String showAdminLoginPage() {
        return "admin-login";
    }

    // Handle Admin Login
    @PostMapping("/admin-login")
    public String handleAdminLogin(@RequestParam String password, Model model) {
        if ("Sunilp13".equals(password)) {
            return "redirect:/admin";
        } else {
            model.addAttribute("error", "Invalid admin password");
            return "admin-login";
        }
    }

}
