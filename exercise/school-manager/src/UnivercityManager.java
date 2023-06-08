import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class UnivercityManager {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Human> humansArrayList = new ArrayList<>();

    public static void menu() {
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

    public static void miniMenu(int choiceMain) {
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
                        case 1, 2 -> addNew(choice);
                        case 4 -> System.exit(0);
                    }
                }
                case 2 -> {
                    switch (choice) {
                        case 1, 2 -> {
                            System.out.print("Nhập số ID muốn xoá: ");
                            int idToRemove = input.nextInt();
                            removeDisplay(idToRemove, choice);
                        }
                        case 4 -> System.exit(0);
                    }
                }
                case 3 -> {
                    switch (choice) {
                        case 1, 2 -> show(choice);
                        case 4 -> System.exit(0);
                    }
                }
            }
        } while (choice != 3);
    }

    public static void show(int choice) {
        boolean flag = choice == 1;
        if (flag) {
            System.out.println("\n---------------------------------------- Danh Sách Học Viên ------------------------------------------");
            System.out.println("------------------------------------------------------------------------------------------------------");
            for (Human human : humansArrayList) {
                if (human instanceof Student) {
                    System.out.println(human);
                }
            }
            System.out.println("------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("\n------------------------------------ Danh Sách Giảng Viên -------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------");
            for (Human human : humansArrayList) {
                if (human instanceof Teacher) {
                    System.out.println(human);
                }
            }
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
    }

    public static void addNew(int choice) {
        boolean flag = choice == 1;
        String human;
        if (flag) {
            human = "học viên";
        } else {
            human = "giảng viên";
        }

        input.nextLine();
        System.out.print("\nNhập tên " + human + ": ");
        String name = input.nextLine();


        System.out.print("Nhập ngày sinh " + human + ": ");
        String date = input.nextLine();

        boolean gender;
        int inputGender;
        do {
            System.out.print("Nhập giới tính " + human + " (nam = 1 || nữ = 0): ");
            inputGender = Integer.parseInt(input.nextLine());
            gender = inputGender == 1;
        } while (inputGender != 1 && inputGender != 0);

        if (flag) {
            System.out.print("Nhập lớp " + human + ": ");
            String room = input.nextLine();
            System.out.print("Nhập điểm " + human + ": ");
            double score = Double.parseDouble(input.nextLine());

            Student student = new Student(name, date, gender, room, score);
            pushStudent(student);
        } else {
            System.out.print("Nhập chuyên môn " + human + ": ");
            String major = input.nextLine();

            Teacher teacher = new Teacher(name, date, gender, major);
            pushTeacher(teacher);
        }
    }

    public static void pushStudent(Student student) {
        humansArrayList.add(student);
        System.out.println("\n----- Done -----");
    }

    public static void pushTeacher(Teacher teacher) {
        humansArrayList.add(teacher);
        System.out.println("\n----- Done -----");
    }

    public static int searchId(int id, int choice) {
        if (id >= humansArrayList.size()) {
            return -1;
        }
        for (int i = 0; i < humansArrayList.size(); i++) {
            if (id == humansArrayList.get(i).getId()) {
                if (choice == 1 && humansArrayList.get(i) instanceof Student) {
                    return i;
                } else if (choice == 2 && humansArrayList.get(i) instanceof Teacher) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void removeDisplay(int id, int choice) {
        int findId = searchId(id, choice);
        if (findId == -1) {
            System.out.println("\nKhông tìm thấy id: " + id);
        } else {
            actionRemove(findId);
        }
    }

    public static void actionRemove(int id) {
        System.out.println(humansArrayList.get(id));
        input.nextLine();
        System.out.print("Xác Nhận Xoá:\n - yes = đồng ý / anykey = cancel : ");
        String answer = input.nextLine().toLowerCase();
        if (Objects.equals(answer, "yes")) {
            humansArrayList.remove(id);
            System.out.println("------ DONE ------");
        } else {
            System.out.println("------ CANCEL ------");
            menu();
        }
    }
}
