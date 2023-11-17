package com.example.vacationhomedemo.service;

import com.example.vacationhomedemo.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(int theId);

    Customer save(Customer theCustomer);

    void deleteById(int theId);

}