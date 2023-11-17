package com.example.vacationhomedemo.service;

import com.example.vacationhomedemo.model.Employee;

import java.util.List;
public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}

