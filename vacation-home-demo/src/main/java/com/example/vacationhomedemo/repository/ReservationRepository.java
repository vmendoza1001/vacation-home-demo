package com.example.vacationhomedemo.repository;

import com.example.vacationhomedemo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository <Reservation, Integer> {


}
