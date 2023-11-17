package com.example.vacationhomedemo.service;

import com.example.vacationhomedemo.model.Administrator;

import java.util.List;
public interface AdministratorService {

    List<Administrator> findAll();

    Administrator findById(int theId);

    Administrator save(Administrator theAdministrator);

    void deleteById(int theId);
}
