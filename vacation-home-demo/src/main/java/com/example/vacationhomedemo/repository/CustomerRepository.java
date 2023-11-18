package com.example.vacationhomedemo.repository;

import com.example.vacationhomedemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer, Integer> {

    List<Customer> findAllByOrderByLastNameAsc();
}
