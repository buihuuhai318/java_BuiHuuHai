package linked_list;

import class_product.Product;

import java.util.Objects;
import java.util.Scanner;

import static linked_list.Display.*;
import static linked_list.Main.products;

public class ProductManager {
    static Scanner input = new Scanner(System.in);

    public static void addNewProduct() {
        System.out.print("Nhập tên sản phẩm: ");
        String name = input.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        int price = Integer.parseInt(input.nextLine());

        products.add(new Product(name, price));
        System.out.println("\n----- Đã thêm mới " + name + " thành công !!! -----\n");
        System.out.println("Enter để tiếp tục !!!");
        input.nextLine();
    }

    public static void removeProduct() {
        int index = search();
        if (index == -1) {
            System.out.println("\n - Không tìm thấy sản phẩm...");
            continueStep();
        } else {
            System.out.println("\n" + products.get(index));
            boolean answer = choice();
            if (answer) {
                products.remove(index);
                doneDisplay();
            } else {
                cancelDisplay();
            }
        }
    }

    public static void editProduct() {
        int index = search();
        if (index == -1) {
            System.out.println("\n - Không tìm thấy sản phẩm...");
            continueStep();
        } else {
            editDisplay(index);
        }
    }

    public static int search() {
        System.out.print("Nhập ID sản phẩm: ");
        int id = Integer.parseInt(input.nextLine());
        for (Product product : products) {
            if (product.getId() == id) {
                return id;
            }
        }
        return -1;
    }

    public static void choiceEdit(int choice, int id) {
        String newName;
        String newPrice;
        switch (choice) {
            case 1 -> {
                System.out.print("- Nhập tên mới: ");
                newName = input.nextLine();
                if (choice() && !Objects.equals(newName, "")) {
                    if (newName != null) {
                        products.get(id).setName(newName);
                        doneDisplay();
                    } else {
                        newName = products.get(id).getName();
                        products.get(id).setName(newName);
                        cancelDisplay();
                    }
                } else {
                    cancelDisplay();
                }
            }
            case 2 -> {
                System.out.print("- Nhập giá mới: ");
                newPrice = input.nextLine();
                if (choice() && !Objects.equals(newPrice, "")) {
                    if (Integer.parseInt(newPrice) > 0) {
                        int newPriceInt = Integer.parseInt(newPrice);
                        products.get(id).setPrice(newPriceInt);
                        doneDisplay();
                    } else {
                        int newPriceInt = products.get(id).getPrice();
                        products.get(id).setPrice(newPriceInt);
                        cancelDisplay();
                    }
                } else {
                    cancelDisplay();
                }
            }
            case 3 -> continueStep();
        }
    }

    public static void searchByName() {
        boolean flag = false;
        int count;
        System.out.print("Nhập tên sản phẩm: ");
        String name = input.nextLine().toLowerCase();
        System.out.println();
        for (Product product : products) {
            for (int j = 0; j < product.getName().length(); j++) {
                if (product.getName().toLowerCase().charAt(j) == name.charAt(0)) {
                    count = 1;
                    for (int k = 1; k < name.length(); k++) {
                        if (product.getName().toLowerCase().charAt(j + k) == name.charAt(k)) {
                            count++;
                        }
                    }
                    if (count == name.length()) {
                        System.out.println(product);
                        flag = true;
                        break;
                    }
                }
            }
        }

        if (!flag) {
            System.out.println("\n - Không tìm thấy sản phẩm...");
            continueStep();
        } else {
            continueStep();
        }
    }

    public static void softByPrice() {
        for (int i = 0; i < products.size(); i++) {
            if (Product.isArrangement()) {
                for (int j = i + 1; j < products.size(); j++) {
                    if (products.get(i).getPrice() > products.get(j).getPrice()) {
                        Product remove = products.remove(j);
                        products.add(i, remove);
                    }
                }
            } else {
                for (int j = i + 1; j < products.size(); j++) {
                    if (products.get(i).getPrice() < products.get(j).getPrice()) {
                        Product remove = products.remove(j);
                        products.add(i, remove);
                    }
                }
            }
        }
        Product.setArrangement(!Product.isArrangement());
    }
}
