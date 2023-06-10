package array_list;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    static Scanner input = new Scanner(System.in);

    public static void addNewProduct(ArrayList<Product> products) {
        System.out.print("Nhập tên sản phẩm: ");
        String name = input.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        int price = Integer.parseInt(input.nextLine());

        products.add(new Product(name, price));
        System.out.println("\n----- Đã thêm mới " + name + " thành công !!! -----\n");
        System.out.println("Enter để tiếp tục !!!");
        input.nextLine();
        Display.displayMenu(products);
    }

    public static void removeProduct(ArrayList<Product> products) {

    }

    public static void editProduct(ArrayList<Product> products) {

    }
}
