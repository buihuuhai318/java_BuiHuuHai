package repository;

import model.Users;

import java.util.List;

public interface IUserRepository {
    void addNew(Users users);

    Users getUsers(int id);

    List<Users> displayUsers();

    void delete(int id);

    void edit(int id, Users users);

    List<Users> searchByCountry(String country);
}
