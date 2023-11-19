package com.example.vacationhomedemo.security.dao;

import org.springframework.security.core.userdetails.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User user);
}
