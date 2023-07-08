package utils;

import model.Car;

import java.util.Comparator;

public class SortByPrice implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        if (o1.getPrice() - o2.getPrice() == 0) {
            return o1.getName().compareTo(o2.getName());
        }
        return o1.getPrice() - o2.getPrice();
    }
}
