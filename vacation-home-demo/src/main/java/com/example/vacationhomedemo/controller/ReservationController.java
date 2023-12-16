package com.example.vacationhomedemo.controller;

import com.example.vacationhomedemo.model.Reservation;
import com.example.vacationhomedemo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // view list of reservations
    @GetMapping
    public String listReservations(Model model) {
        List<Reservation> reservations = reservationService.findAll();
        model.addAttribute("reservations", reservations);
        return "reservations/list-reservations";
    }

    // view single reservation
    @GetMapping("/{reservationId}")
    public String viewReservation(@PathVariable int reservationId, Model model) {
        Reservation reservation = reservationService.findById(reservationId);
        model.addAttribute("reservation", reservation);
        return "reservations/view-reservation";
    }

    // add reservation
    @GetMapping("/reservation")
    public String showAddForm(Model model) {
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        return "reservations/add-reservation";
    }

    // save reservation
    @PostMapping("/save")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation, RedirectAttributes redirectAttributes) {
        Reservation savedReservation = reservationService.save(reservation);
        redirectAttributes.addFlashAttribute("reservation", savedReservation);
        return "redirect:/reservations/confirm/" + savedReservation.getId();
    }

    // confirm reservation
    @GetMapping("/confirm/{reservationId}")
    public String showConfirmation(@PathVariable int reservationId, Model model) {
        Reservation reservation = reservationService.findById(reservationId);
        model.addAttribute("reservation", reservation);
        return "reservations/confirmation";
    }

    // delete reservation
    /* @GetMapping("/delete/{reservationId}")
    public String deleteReservation(@PathVariable int reservationId) {
        reservationService.deleteById(reservationId);
        return "redirect:/reservations"; // Redirect to list reservations
    } */

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PostMapping("/edit/{id}")
    public String editReservation(@PathVariable int id, @ModelAttribute("reservation") Reservation reservation, RedirectAttributes redirectAttributes) {
        reservationService.save(reservation);
        redirectAttributes.addFlashAttribute("successMessage", "Reservation updated successfully!");
        return "redirect:/reservations"; // Redirecting to the list of reservations after successful edit
    }


    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable int id, RedirectAttributes redirectAttributes) {
        reservationService.deleteById(id); // Assuming you have a service method to delete a reservation by id
        redirectAttributes.addFlashAttribute("successMessage", "Reservation deleted successfully!");
        return "redirect:/reservations"; // Redirecting to the list of reservations after deletion
    }

}