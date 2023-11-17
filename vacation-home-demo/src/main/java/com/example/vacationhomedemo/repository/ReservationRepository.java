package com.example.vacationhomedemo.repository;

import com.example.vacationhomedemo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository <Reservation, Integer> {


    List<Reservation> findAllByOrderByLastNameAsc();
}
