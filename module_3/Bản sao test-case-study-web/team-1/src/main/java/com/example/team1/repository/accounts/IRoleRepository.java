package com.example.team1.repository.accounts;

import com.example.team1.model.accounts.Roles;

import java.util.Map;

public interface IRoleRepository {
    Roles selectRole(int id);

    Map<Integer, Roles> selectAllRole();
}
