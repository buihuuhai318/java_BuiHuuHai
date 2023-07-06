package controller;

import service.CarService;
import service.ICarService;
import utils.ReadAndWrite;

import static view.Main.input;

public class CarController {
    ICarService carService = new CarService();

    public void displayMenu() {
        while (true) {
            System.out.println("1. Tạo các đối tượng xe và nhập thông tin\n" +
                    "2. Xuất bảng các xe.\n" +
                    "3. sapa xep theo xy lanh.\n" +
                    "4. Xoa \n" +
                    "5. Sua \n" +
                    "6. sap xep theo gia \n" +
                    "6. Thoát\n");
            int choice = ReadAndWrite.inputInt();
            System.out.println("nhap chuc nang");
            switch (choice) {
                case 1 -> carService.addNew();
                case 2 -> carService.display();
                case 3 -> carService.displayByVolume();
                case 4 -> carService.remove();
                case 5 -> carService.edit();
                case 6 -> carService.displayByPrice();
                case 7 -> System.exit(0);
            }
        }
    }
}
