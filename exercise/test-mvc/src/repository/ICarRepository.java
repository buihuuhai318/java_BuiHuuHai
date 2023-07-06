package repository;

import model.Car;

import java.util.List;

public interface ICarRepository {
    void edit(int index, Car car);
    void remove(int index);
    void addNew(Car car);
    List<Car> toListCar();
    int searchId(int id);
    Car getCar(int index);
    List<Car> sortByVolume();
    List<Car> sortByPrice();
}
