package com.example.demo.Controller;

import com.example.demo.Model.Menu;
import com.example.demo.Model.Reservation;
import com.example.demo.service.MenuService;
import com.example.demo.service.ReservationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private MenuService menuService;

    // Show reservation form
    @GetMapping("/reservation")
    public String showReservationForm(Model model) {
        List<Menu> menuItems = menuService.getAllMenuItems();  // Get menu items from MenuService
        model.addAttribute("menuItems", menuItems);  // Add menu items to model
        model.addAttribute("reservation", new Reservation());  // Initialize an empty Reservation object
        return "reservation";  // Return reservation view
    }

    // Submit reservation
    @PostMapping("/reservation/save")
    public String saveReservation(@ModelAttribute Reservation reservation,
                                  @RequestParam("menuIds") List<Integer> menuIds,
                                  HttpSession session) {

        Integer userId = (Integer) session.getAttribute("userId");  // Get user ID from session
        if (userId == null) {
            return "redirect:/login";  // If user is not logged in, redirect to login page
        }

        reservation.setUserId(userId);  // Set the user ID to the reservation
        reservation.setReservationDate(LocalDate.now());  // Set the reservation date to today's date

        reservationService.saveReservation(reservation, menuIds);  // Save reservation with associated menu items
        return "redirect:/home";  // Redirect to home page after saving the reservation
    }
}
