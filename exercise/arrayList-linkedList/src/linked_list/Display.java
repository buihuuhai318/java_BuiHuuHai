package linked_list;

import class_product.Product;

import java.util.Scanner;

import static linked_list.Main.products;
import static linked_list.ProductManager.*;

public class Display {
    static Scanner input = new Scanner(System.in);

    public static void displayMenu() {
        do {
            System.out.println("\n------------- Phần Mền Quản Lý Sản Phẩm --------------");
            System.out.println("------------------------------------------------------");
            displayListProduct();
            System.out.println("------------------------------------------------------");
            System.out.println("\n1. Thêm Mới");
            System.out.println("2. Sữa Thông Tin Sản Phẩm");
            System.out.println("3. Xoá Sản Phẩm");
            System.out.println("4. Tìm Sản Phẩm Theo Tên");
            System.out.println("5. Sắp Xếp Theo Giá Tăng/Giảm Dần");
            System.out.println("6. Thoát");
            System.out.print("\nNhập số để lựa chọn chức năng: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> addNewProduct();
                case 2 -> editProduct();
                case 3 -> removeProduct();
                case 4 -> searchByName();
                case 5 -> softByPrice();
                case 6 -> System.exit(0);
            }
        } while (true);
    }

    public static void displayListProduct() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void continueStep() {
        System.out.print("\nEnter để tiếp tục.....");
        input.nextLine();
    }

    public static void editDisplay(int id) {
        int choice;
        do {
            System.out.println("\n1. " + products.get(id).getName());
            System.out.println("2. " + products.get(id).getPrice());
            System.out.println("3. Thoát");
            System.out.print("\n - Chọn thông tin bạn muốn sửa: ");
            choice = Integer.parseInt(input.nextLine());
            choiceEdit(choice, id);
        } while (choice != 3);
    }

    public static boolean choice() {
        System.out.print("\n - Nhập YES để tiếp tục: ");
        String answer = input.nextLine().toLowerCase();
        return answer.equals("yes");
    }

    public static void doneDisplay() {
        System.out.println("\n-------- Done --------");
        Display.continueStep();
    }

    public static void cancelDisplay() {
        System.out.println("\n-------- Cancel --------");
        Display.continueStep();
    }
}
