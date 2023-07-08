package controller;

import service.CarService;
import service.ICarService;

import static view.Main.input;

public class CarController {
    ICarService carService = new CarService();

    public void displayMenu() {
        while (true) {
            System.out.println("1. Tạo các đối tượng xe và nhập thông tin\n" +
                    "2. Xuất bảng các xe.\n" +
                    "3. Xuất bảng kê khai tiền thuế của các xe.\n" +
                    "4. Thoát\n");
            int choice = Integer.parseInt(input.nextLine());
            System.out.println("nhap chuc nang");
            switch (choice) {
                case 1 -> carService.addNew();
                case 2 -> carService.display();
                case 3 -> carService.displayTax();
                case 4 -> System.exit(0);
            }
        }
    }
}
