package com.example.vacationhomedemo.controller;

import com.example.vacationhomedemo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

}
