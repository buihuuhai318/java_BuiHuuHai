package com.example.team1.service.accounts;

import com.example.team1.model.accounts.Roles;

import java.util.Map;

public interface IRoleService {
    Roles selectRole(int id);

    Map<Integer, Roles> selectAllRole();
}
