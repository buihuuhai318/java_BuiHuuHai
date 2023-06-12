package array_list;

import class_product.Product;

import java.util.ArrayList;

import static array_list.Display.*;

public class Main {
    public static ArrayList<Product> products = new ArrayList<>();

    static {
        products.add(new Product("Iphone 13", 1000));
        products.add(new Product("Iphone 14", 2000));
        products.add(new Product("Iphone 14 pro max", 3000));
        products.add(new Product("Iphone 15 pro max", 4000));
    }

    public static void main(String[] args) {
        displayMenu();
    }
}