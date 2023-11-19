package com.example.vacationhomedemo.security.service;

import com.example.vacationhomedemo.security.user.WebUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);

    void save(WebUser webUser);
}
