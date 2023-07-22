package service;

import model.Users;
import repository.IUserRepository;
import repository.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    private static IUserRepository userRepository = new UserRepository();
    @Override
    public void addNew(Users users) {
        userRepository.addNew(users);
    }

    @Override
    public Users getUser(int id) {
        return userRepository.getUsers(id);
    }

    @Override
    public List<Users> displayUser() {
        return userRepository.displayUsers();
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public void edit(int id, Users users) {
        userRepository.edit(id, users);
    }

    @Override
    public List<Users> searchByCountry(String country) {
        return userRepository.searchByCountry(country);
    }
}
