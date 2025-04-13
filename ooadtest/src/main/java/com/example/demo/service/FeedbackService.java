package com.example.demo.service;

import com.example.demo.Model.Feedback;
import com.example.demo.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public void saveFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    public List<Feedback> getFeedbacksByMenuId(int menuId) {
        return feedbackRepository.findByMenuId(menuId);  // Uses correct repository method
    }

    public List<Feedback> getFeedbacksByUserId(int userId) {
        return feedbackRepository.findByUserId(userId);  // Uses correct repository method
    }
}
