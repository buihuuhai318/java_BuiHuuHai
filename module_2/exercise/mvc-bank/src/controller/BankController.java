package controller;

import common.Common;

public class BankController {
    public void displayMenu() {
        while (true) {
            System.out.println("1. Phương thức nạp tiền vào tài khoản \n" +
                    "2. Phương thức rút tiền \n" +
                    "3. Phương thức đáo hạn \n" +
                    "4. Phương thức chuyển khoản \n");
            System.out.println(" - enter your action: ");
            int choice = Common.inputInt();
            switch (choice) {
                case 1 -> System.out.println("nap tien");
                case 2 -> System.out.println("rut tien");
                case 3 -> System.out.println("dao han");
                case 4 -> System.out.println("chuyen khoan");
                case 5 -> System.exit(0);
            }
        }
    }
}
