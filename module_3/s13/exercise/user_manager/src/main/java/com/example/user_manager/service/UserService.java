package com.example.user_manager.service;

import com.example.user_manager.model.Users;
import com.example.user_manager.repository.IUserRepository;
import com.example.user_manager.repository.UserRepository;
import com.example.user_manager.until.Regex;

import java.util.List;

public class UserService implements IUsersService {
    private static final IUserRepository userRepository = new UserRepository();

    @Override
    public List<Users> display() {
        return userRepository.selectAllUsers();
    }

    @Override
    public void add(Users users) {
        userRepository.insertUser(users);
    }

    @Override
    public Users findById(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteUsers(id);
    }

    @Override
    public void edit(int id, Users users) {
        userRepository.updateUsers(id, users);
    }

    @Override
    public List<Users> findCountry(String country) {
        return userRepository.findCountry(country);
    }
}
