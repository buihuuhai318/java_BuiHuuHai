package service;

import model.Vehicle;
import repository.CarRepository;
import repository.ICarRepository;

import static view.Main.input;

public class CarService implements ICarService {
    ICarRepository carRepository = new CarRepository();

    @Override
    public void display() {
        for (Vehicle vehicle : carRepository.toList()) {
            System.out.println(vehicle);
        }
    }

    @Override
    public void addNew() {
        System.out.println("nhap id: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("nhap ten: ");
        String name = input.nextLine();
        System.out.println("nhap gia tien: ");
        int price = Integer.parseInt(input.nextLine());
        System.out.println("nhap dung tich xy lanh: ");
        int capacity = Integer.parseInt(input.nextLine());
        Vehicle vehicle = new Vehicle(id, name, capacity, price);
        carRepository.addNew(vehicle);
    }

    @Override
    public void displayTax() {
        for (Vehicle vehicle : carRepository.toList()) {
            System.out.println(vehicle.getNameCar() + "-" + vehicle.getCapacity() + "-" + vehicle.getTax());
        }
    }
}
