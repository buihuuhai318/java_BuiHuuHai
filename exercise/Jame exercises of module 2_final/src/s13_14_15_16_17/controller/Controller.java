package s13_14_15_16_17.controller;

import s13_14_15_16_17.service.Service;

import static s13_14_15_16_17.view.Main.input;

public class Controller {

    Service service = new Service();
    public void menu() {
        int choice;
        do {
            System.out.println("1. Hiển thị danh sách \n" +
                    "2. Thêm \n" +
                    "3. Xóa \n" +
                    "4. Sửa \n" +
                    "5. Tìm kiếm theo mã chi tiêu \n" +
                    "6. Tìm kiếm gần đúng theo tên chi tiêu \n" +
                    "7. Exit");
            System.out.print("nhập lựa chọn theo số: ");
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1 -> service.display();
                case 2 -> service.addNew();
                case 3 -> service.remove();
                case 7 -> System.exit(0);
            }
        } while (true);
    }
}
