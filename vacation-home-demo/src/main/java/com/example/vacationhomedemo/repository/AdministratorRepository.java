package com.example.vacationhomedemo.repository;

import com.example.vacationhomedemo.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository <Administrator, Integer> {

}
