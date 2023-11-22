package com.example.vacationhomedemo.controller;

import jakarta.persistence.Column;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/customer")
    public String customer() {

        return "reservation";
    }

    @GetMapping("/employee")
    public String employee() {

        return "reservations-list-read-only";
    }

    @GetMapping("/administrator")
    public String administrator() {

        return "reservations-list";
    }

}
