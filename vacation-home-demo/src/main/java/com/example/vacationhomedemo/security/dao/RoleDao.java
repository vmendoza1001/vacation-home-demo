package com.example.vacationhomedemo.security.dao;

import com.example.vacationhomedemo.security.model.Role;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);

}
