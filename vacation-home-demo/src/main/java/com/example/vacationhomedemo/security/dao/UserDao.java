package com.example.vacationhomedemo.security.dao;

import com.example.vacationhomedemo.security.model.User;

public interface UserDao {

    com.example.vacationhomedemo.security.model.User findByUserName(String userName);

    void save(User user);

}
