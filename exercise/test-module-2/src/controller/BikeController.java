package controller;

import common.CheckInput;
import service.BikeService;
import service.IBikeService;

public class BikeController {

    IBikeService bikeService = new BikeService();

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n");
            System.out.println("1. Hiển Thị Danh Sách \n" +
                    "2. Thêm Mới Phương Tiện \n" +
                    "3. Đăng Ký Biển Số Xe \n" +
                    "4. Thoát");

            System.out.print("\n - Nhập chức năng: ");
            choice = CheckInput.inputInt();

            switch (choice) {
                case 1 -> bikeService.display();
                case 2 -> bikeService.addNew();
                case 3 -> bikeService.addNewBikeNumber();
                case 4 -> System.exit(0);
            }
        } while (true);
    }
}
