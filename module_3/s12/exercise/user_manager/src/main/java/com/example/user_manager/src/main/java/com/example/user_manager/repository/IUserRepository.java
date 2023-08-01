package com.example.user_manager.repository;

import com.example.user_manager.model.Users;

import java.util.List;

public interface IUserRepository {
   void insertUser(Users users);

   Users selectUser(int id);

   List<Users> selectAllUsers();

   void deleteUsers(int id);

   void updateUsers(int id, Users users);

   List<Users> findCountry(String country);
}
