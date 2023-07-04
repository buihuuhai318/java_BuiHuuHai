package repository;

import common.ReadAndWrite;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository {

    @Override
    public void addNew(Vehicle vehicle) {
        List<String> stringList = toFile();
        stringList.add(vehicle.toFile());
        ReadAndWrite.write(ReadAndWrite.CAR_FILE, stringList, false);
    }

    @Override
    public List<String> toFile() {
        List<String> stringList = new ArrayList<>();
        for (Vehicle vehicle : toList()) {
            stringList.add(vehicle.toFile());
        }
        return stringList;
    }

    @Override
    public List<Vehicle> toList() {
        List<String> stringList = ReadAndWrite.read(ReadAndWrite.CAR_FILE);
        List<Vehicle> vehicleList = new ArrayList<>();
        for (String line : stringList) {
            String[] info = line.split(",");
            vehicleList.add(new Vehicle(Integer.parseInt(info[0]), info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3])));
        }
        return vehicleList;
    }
}
