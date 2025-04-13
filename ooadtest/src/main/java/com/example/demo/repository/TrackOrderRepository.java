package com.example.demo.repository;

import com.example.demo.Model.TrackOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackOrderRepository extends JpaRepository<TrackOrder, Integer> {

    // Method to find a TrackOrder by menuId, month, and year
    TrackOrder findByMenuIdAndMonthAndYear(int menuId, int month, int year);
}
