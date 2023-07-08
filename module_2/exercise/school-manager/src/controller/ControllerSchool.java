package controller;

import service.student.StudentService;
import service.teacher.TeacherService;

import static view.Main.input;

public class ControllerSchool {
    StudentService studentService = new StudentService();
    TeacherService teacherService = new TeacherService();

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
            choiceMain = input.nextInt();
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
            choice = input.nextInt();
            switch (choiceMain) {
                case 1 -> {
                    switch (choice) {
                        case 1 -> studentService.addNew();
                        case 2 -> teacherService.addNew();
                        case 4 -> System.exit(0);
                    }
                }
                case 2 -> {
                    switch (choice) {
                        case 1 -> {
                            System.out.print("Nhập số ID muốn xoá: ");
                            int idToRemove = input.nextInt();
                            studentService.remove(idToRemove);
                        }
                        case 2 -> {
                            System.out.print("Nhập số ID muốn xoá: ");
                            int idToRemove = input.nextInt();
                            teacherService.remove(idToRemove);
                        }
                        case 4 -> System.exit(0);
                    }
                }
                case 3 -> {
                    switch (choice) {
                        case 1 -> studentService.display();
                        case 2 -> teacherService.display();
                        case 4 -> System.exit(0);
                    }
                }
            }
        } while (choice != 3);
    }
}
