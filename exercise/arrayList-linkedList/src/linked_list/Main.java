package linked_list;

import class_product.Product;

import java.util.LinkedList;

import static linked_list.Display.displayMenu;

public class Main {
    public static LinkedList<Product> products = new LinkedList<>();

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