package com.example.demo.repository;

import com.example.demo.Model.Reservation;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
    List<Reservation> findByUserId(int userId);  // This should work now with userId field in entity
}
