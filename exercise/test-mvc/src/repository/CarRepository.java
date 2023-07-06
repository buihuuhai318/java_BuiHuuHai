package repository;

import model.Car;
import utils.ReadAndWrite;
import utils.SortByPrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository implements ICarRepository {
    @Override
    public void edit(int index, Car car) {
        List<String> stringList = ReadAndWrite.read(ReadAndWrite.PATH_FILE_CAR);
        stringList.set(index, car.toFile());
        ReadAndWrite.write(ReadAndWrite.PATH_FILE_CAR, stringList, false);
    }

    @Override
    public void remove(int index) {
        List<String> stringList = ReadAndWrite.read(ReadAndWrite.PATH_FILE_CAR);
        stringList.remove(index);
        ReadAndWrite.write(ReadAndWrite.PATH_FILE_CAR, stringList, false);
    }

    @Override
    public void addNew(Car car) {
        List<String> stringList = ReadAndWrite.read(ReadAndWrite.PATH_FILE_CAR);
        stringList.add(car.toFile());
        ReadAndWrite.write(ReadAndWrite.PATH_FILE_CAR, stringList, false);
    }

    @Override
    public List<Car> toListCar() {
        List<String> stringList = ReadAndWrite.read(ReadAndWrite.PATH_FILE_CAR);
        List<Car> carList = new ArrayList<>();
        String[] info;
        for (String line : stringList) {
            info = line.split(",");
            
            carList.add(new Car(Integer.parseInt(info[0]), info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3])));
        }
        return carList;
    }

    @Override
    public int searchId(int id) {
        for (int i = 0; i < toListCar().size(); i++) {
            if (toListCar().get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Car getCar(int index) {
        return toListCar().get(index);
    }

    @Override
    public List<Car> sortByVolume() {
        List<Car> list = toListCar();
        Collections.sort(list);
        List<String> stringList = new ArrayList<>();
        for (Car car : list) {
            stringList.add(car.toFile());
        }
        ReadAndWrite.write(ReadAndWrite.PATH_FILE_CAR, stringList, false);
        return list;
    }

    @Override
    public List<Car> sortByPrice() {
        List<Car> list = toListCar();
        Collections.sort(list, new SortByPrice());
        return list;
    }
}
