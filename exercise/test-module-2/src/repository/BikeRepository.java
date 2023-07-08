package repository;

import common.NotFoundException;
import model.Bike;
import utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class BikeRepository implements IBikeRepository {

    @Override
    public List<Bike> toListBike() {
        List<String> stringList = ReadAndWrite.readFile(ReadAndWrite.PATH_FILE_Bike);
        List<Bike> bikeList = new ArrayList<>();
        String[] info;
        for (String line : stringList) {
            info = line.split(",");
            bikeList.add(new Bike(info[0], info[1], Integer.parseInt(info[2]), info[3], info[4]));
        }
        return bikeList;
    }

    @Override
    public void addNew(Bike bike) {
        List<String> stringList = ReadAndWrite.readFile(ReadAndWrite.PATH_FILE_Bike);
        stringList.add(bike.toFile());
        ReadAndWrite.writeFile(ReadAndWrite.PATH_FILE_Bike, stringList);
    }

    @Override
    public void addNewBikeNumber(int index, String bikeNumber) {
        List<Bike> bikeList = toListBike();
        bikeList.get(index).setBikeNumber(bikeNumber);
        List<String> stringList = ReadAndWrite.readFile(ReadAndWrite.PATH_FILE_Bike);
        stringList.set(index, bikeList.get(index).toFile());
        ReadAndWrite.writeFile(ReadAndWrite.PATH_FILE_Bike, stringList);
    }

    @Override
    public Bike getBike(int index) throws NotFoundException {
        List<Bike> bikeList = toListBike();
        return bikeList.get(index);
    }

    @Override
    public int searchBike(String id) throws NotFoundException {
        List<Bike> bikeList = toListBike();
        for (int i = 0; i < bikeList.size(); i++) {
            if (bikeList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
