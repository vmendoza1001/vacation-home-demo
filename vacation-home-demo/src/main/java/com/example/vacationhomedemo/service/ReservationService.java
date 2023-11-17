package com.example.vacationhomedemo.service;

import com.example.vacationhomedemo.model.Reservation;

import java.util.List;
public interface ReservationService {

    List<Reservation> findAll();

    Reservation findById(int theId);

    Reservation save(Reservation theReservation);

    void deleteById(int theId);
}
