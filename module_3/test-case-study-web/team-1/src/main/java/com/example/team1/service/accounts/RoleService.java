package com.example.team1.service.accounts;

import com.example.team1.model.accounts.Roles;
import com.example.team1.repository.accounts.RoleRepository;

import java.util.Map;

public class RoleService implements IRoleService {
    private final RoleRepository roleRepository = new RoleRepository();
    @Override
    public Roles selectRole(int id) {
        return roleRepository.selectRole(id);
    }

    @Override
    public Map<Integer, Roles> selectAllRole() {
        return roleRepository.selectAllRole();
    }
}
