package com.example.vacationhomedemo.repository;

import com.example.vacationhomedemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {

    List<Employee> findAllByOrderByLastNameAsc();
}
