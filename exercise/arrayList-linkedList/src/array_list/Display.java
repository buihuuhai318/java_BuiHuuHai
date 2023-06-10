package array_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {
    static Scanner input = new Scanner(System.in);

    public static void displayMenu(ArrayList<Product> products) {
        do {
            System.out.println("\n------------- Phần Mền Quản Lý Sản Phẩm --------------");
            System.out.println("------------------------------------------------------");
            displayListProduct(products);
            System.out.println("------------------------------------------------------");
            System.out.println("\n1. Thêm Mới");
            System.out.println("2. Sữa Thông Tin Sản Phẩm");
            System.out.println("3. Xoá Sản Phẩm");
            System.out.println("4. Thoát");
            System.out.print("\nNhập số để lựa chọn chức năng: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> ProductManager.addNewProduct(products);
                case 2 -> System.out.println("display");
                case 3 -> System.exit(0);
            }
        } while (true);
    }

    public static void displayListProduct(ArrayList<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
