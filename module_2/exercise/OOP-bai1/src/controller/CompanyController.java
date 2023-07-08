package controller;

import service.CompanyService;

import static view.Main.input;

public class CompanyController {
    CompanyService companyService = new CompanyService();

    public void displayMenu() {
        do {
            System.out.println("1. Nhập thông tin mới cho cán bộ\n" +
                    "2. Tìm kiếm theo họ tên\n" +
                    "3. Sắp xếp theo tên\n" +
                    "4. Hiển thị thông tin về danh sách các cán bộ\n" +
                    "5. Thoát khỏi chương trình.\n");
            System.out.println("nhap chuc nang: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> companyService.addNew();
                case 2 -> companyService.searchByName();
                case 3 -> companyService.sortByName();
                case 4 -> companyService.display();
                case 5 -> System.exit(0);
            }
        } while (true);
    }
}
