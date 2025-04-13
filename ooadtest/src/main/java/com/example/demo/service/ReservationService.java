package com.example.demo.service;

import com.example.demo.Model.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TrackOrderService trackOrderService;

    public void saveReservation(Reservation reservation, List<Integer> menuIds) {
        reservationRepository.save(reservation);

        // For each menu item selected during reservation, update tracking
        for (Integer menuId : menuIds) {
            trackOrderService.updateReservationCount(menuId);
        }
    }


    public List<Reservation> getReservationsByUserId(int userId) {
        return reservationRepository.findByUserId(userId);
    }

    public void deleteReservation(int reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
