package com.example.demo.service;

import com.example.demo.Model.TrackOrder;
import com.example.demo.repository.TrackOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TrackOrderService {

    @Autowired
    private TrackOrderRepository trackOrderRepository;

    // Method to update the reservation count
    public void updateReservationCount(int menuId) {
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int year = today.getYear();

        // Find the TrackOrder based on menuId, month, and year
        TrackOrder track = trackOrderRepository.findByMenuIdAndMonthAndYear(menuId, month, year);

        if (track != null) {
            track.setReservationsCount(track.getReservationsCount() + 1);  // Use the correct method for reservationsCount
        } else {
            track = new TrackOrder();
            track.setMenuId(menuId);  // Set the correct field
            track.setMonth(month);
            track.setYear(year);
            track.setReservationsCount(1);  // Set the count for reservations
            track.setOrdersCount(0);  // Set orders count to 0 initially
        }

        // Save the updated TrackOrder
        trackOrderRepository.save(track);
    }

    // Method to update the order count
    public void updateOrderCount(int menuId, int quantity) {
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int year = today.getYear();

        // Find the TrackOrder based on menuId, month, and year
        TrackOrder track = trackOrderRepository.findByMenuIdAndMonthAndYear(menuId, month, year);

        if (track != null) {
            track.setOrdersCount(track.getOrdersCount() + quantity);  // Use the correct method for ordersCount
        } else {
            track = new TrackOrder();
            track.setMenuId(menuId);  // Set the correct field
            track.setMonth(month);
            track.setYear(year);
            track.setReservationsCount(0);  // Set reservations count to 0 initially
            track.setOrdersCount(quantity);  // Set the orders count based on the quantity
        }

        // Save the updated TrackOrder
        trackOrderRepository.save(track);
    }
}
