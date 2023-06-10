package array_list;

import java.util.ArrayList;

public class Main {
    static ArrayList<Product> products = new ArrayList<>();
    static {
        products.add(new Product("Iphone 13", 1000));
        products.add(new Product("Iphone 14", 2000));
        products.add(new Product("Iphone 14 pro max", 3000));
        products.add(new Product("Iphone 15 pro max", 4000));
    }
    public static void main(String[] args) {
        Display.displayMenu(products);
    }
}