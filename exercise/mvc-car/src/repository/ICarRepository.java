package repository;

import model.Vehicle;

import java.util.List;

public interface ICarRepository {
    void addNew(Vehicle vehicle);
    List<String> toFile();
    List<Vehicle> toList();
}
