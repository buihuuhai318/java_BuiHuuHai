package repository;

import common.NotFoundException;
import model.Bike;

import java.util.List;

public interface IBikeRepository {
    List<Bike> toListBike();

    void addNew(Bike bike);

    void addNewBikeNumber(int index, String bikeNumber);

    Bike getBike(int index) throws NotFoundException;

    int searchBike(String id) throws NotFoundException;
}
