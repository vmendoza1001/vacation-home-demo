package com.example.vacationhomedemo.serviceimpl;

import com.example.vacationhomedemo.model.Reservation;
import com.example.vacationhomedemo.repository.ReservationRepository;
import com.example.vacationhomedemo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;
    @Autowired
    public ReservationServiceImpl(ReservationRepository theReservationRepository) { reservationRepository = theReservationRepository;}

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(int theId) {
        Optional<Reservation> result = reservationRepository.findById(theId);

        Reservation theReservation = null;

        if (result.isPresent()) {
            theReservation = result.get();
        }
        else {
            throw new RuntimeException("Did not find reservation id - " + theId);
        }

        return theReservation;
    }

    @Override
    public Reservation save(Reservation theReservation) {return reservationRepository.save(theReservation);}

    @Override
    public void deleteById(int theId) {reservationRepository.deleteById(theId);}
}
