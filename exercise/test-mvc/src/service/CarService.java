package service;

import model.Car;
import repository.CarRepository;
import repository.ICarRepository;
import utils.NotFoundIdException;
import utils.ReadAndWrite;

import static view.Main.input;

public class CarService implements ICarService {

    ICarRepository repository = new CarRepository();

    @Override
    public void addNew() {
        System.out.println("nhap id");
        int id = ReadAndWrite.inputInt();
        System.out.println("nhap ten");
        String name = input.nextLine();
        System.out.println("nhap xy lanh");
        int volume = ReadAndWrite.inputInt();
        System.out.println("nhap gia");
        int price = (int) Double.parseDouble(input.nextLine());

        Car car = new Car(id, name, price, volume);
        repository.addNew(car);
    }

    @Override
    public void display() {
        for (Car car : repository.toListCar()) {
            System.out.println(car);
        }
    }

    @Override
    public void edit() {
        boolean flag = true;
        Car car;
        System.out.println("nhap id can xoa: ");
        int id = ReadAndWrite.inputInt();
        int index = repository.searchId(id);

        if (index == -1) {
            try {
                throw new NotFoundIdException("exception khong tim thay");
            } catch (NotFoundIdException e) {
//               e.printStackTrace();
                System.out.println("khong tim thay");
            }
        } else {
            car = repository.getCar(index);
            do {
                System.out.println(car);
                System.out.println("1. id \n" +
                        "2. name \n" +
                        "3. price \n" +
                        "4. volume \n" +
                        "5. save \n");
                System.out.println("nhap thuoc tinh can sua: ");

                int action = ReadAndWrite.inputInt();

                switch (action) {
                    case 1 -> {
                        System.out.println("nhap id moi");
                        int newId = ReadAndWrite.inputInt();
                        car.setId(newId);
                    }
                    case 2 -> {
                        System.out.println("nhap ten moi");
                        String name = input.nextLine();
                        if (name.trim().equals("")) {
                            name = car.getName();
                        } else {
                            car.setName(name);
                        }
                    }
                    case 3 -> {
                        System.out.println("nhap gia moi");
                        int price = ReadAndWrite.inputInt();
                        car.setPrice(price);
                    }
                    case 4 -> {
                        System.out.println("nhap xy lanh moi");
                        int volume = ReadAndWrite.inputInt();
                        car.setVolume(volume);
                    }
                    case 5 -> flag = false;
                    default -> System.out.println("nhap sai");
                }
            } while (flag);
            System.out.println("save = yes");
            String choice = input.nextLine().toLowerCase().trim();
            if (choice.equals("yes")) {
                repository.edit(index, car);
            } else {
                System.out.println("cancel");
            }
        }
    }

    @Override
    public void remove() {
        System.out.println("nhap id can xoa: ");
        int id = ReadAndWrite.inputInt();
        int index = repository.searchId(id);
        if (index == -1) {
            System.out.println("khong tim thay");
        } else {
            System.out.println(repository.getCar(index));
            System.out.println("xoa = yes");
            String choice = input.nextLine().toLowerCase().trim();
            if (choice.equals("yes")) {
                repository.remove(index);
            } else {
                System.out.println("cancel");
            }
        }
    }

    @Override
    public void displayTax() {

    }

    @Override
    public void displayByVolume() {
        for (Car car : repository.sortByVolume()) {
            System.out.println(car);
        }
    }

    @Override
    public void displayByPrice() {
        for (Car car : repository.sortByPrice()) {
            System.out.println(car);
        }
    }
}
