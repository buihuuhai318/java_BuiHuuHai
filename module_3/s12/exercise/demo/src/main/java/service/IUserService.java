package service;

import model.Users;

import java.util.List;

public interface IUserService {
    void addNew(Users users);

    Users getUser(int id);

    List<Users> displayUser();

    void delete(int id);

    void edit(int id, Users users);

    List<Users> searchByCountry(String country);
}
