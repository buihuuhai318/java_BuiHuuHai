package controller;

import service.StudentService;

import static view.Main.input;


public class Controller {

    StudentService studentService = new StudentService();
    public void menu() {
        int choiceMain;
        do {
            System.out.println("\n--- Chương Trình Quản Lý Sinh Viên ---\n");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Thêm mới giảng viên hoặc học viên");
            System.out.println("2. Xoá giảng viên hoặc học viên");
            System.out.println("3. Xem danh sách giảng viên hoặc học viên");
            System.out.println("4. Thoát\n");
            System.out.print("Chọn chức năng: ");
            choiceMain = Integer.parseInt(input.nextLine());
            switch (choiceMain) {
                case 1, 2, 3 -> miniMenu(choiceMain);
                case 4 -> System.exit(0);
            }
        } while (true);
    }

    public void miniMenu(int choiceMain) {
        int choice;
        do {
            switch (choiceMain) {
                case 1 -> System.out.println("\n----- Thêm Mới -----");
                case 2 -> System.out.println("\n-------- Xoá --------");
                case 3 -> System.out.println("\n----- Danh Sách -----");
            }
            System.out.println("\n1. Học viên");
            System.out.println("2. Giảng viên");
            System.out.println("3. Quay lại");
            System.out.println("4. Thoát\n");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choiceMain) {
                case 1 -> {
                    switch (choice) {
                        case 1 -> studentService.addNew();
                        case 2 -> System.out.println("");
                        case 4 -> System.exit(0);
                    }
                }
                case 2 -> {
                    switch (choice) {
                        case 1 -> {
                            studentService.remove();
                        }
                        case 2 -> {
                            System.out.println("");
                        }
                        case 4 -> System.exit(0);
                    }
                }
                case 3 -> {
                    switch (choice) {
                        case 1 -> studentService.display();
                        case 2 -> System.out.println("");
                        case 4 -> System.exit(0);
                    }
                }
            }
        } while (choice != 3);
    }
}
