package com.example.demo.repository;

import com.example.demo.Model.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {

    List<Feedback> findByMenuId(int menuId);  // Matches field 'menuId' in entity

    List<Feedback> findByUserId(int userId);  // Matches field 'userId' in entity
}
