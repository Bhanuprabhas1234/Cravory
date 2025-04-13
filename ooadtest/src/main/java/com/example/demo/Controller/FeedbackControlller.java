package com.example.demo.Controller;

import com.example.demo.Model.Feedback;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.service.MenuService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FeedbackControlller {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private MenuService menuService;

    // Show feedback page
    @GetMapping("/feedback")
    public String showFeedbackPage(Model model) {
        model.addAttribute("menuItems", menuService.getAllMenuItems());  // Fetch menu items
        return "feedback";  // Return the view
    }

    // Submit feedback
    @PostMapping("/feedback/submit")
    public String submitFeedback(@RequestParam("menu_id") int menuId,
                                 @RequestParam("feedback_text") String feedbackText,
                                 HttpSession session) {

        Integer userId = (Integer) session.getAttribute("userId");  // Ensure session attribute name matches 'userId'
        if (userId != null) {
            Feedback feedback = new Feedback();
            feedback.setUserId(userId);  // Set userId from session
            feedback.setMenuId(menuId);  // Set menuId from request parameter
            feedback.setFeedbackText(feedbackText);  // Set feedback text from request parameter
            feedbackRepository.save(feedback);  // Save feedback to repository
        }
        return "redirect:/home";  // Redirect to home page after submitting feedback
    }
}
