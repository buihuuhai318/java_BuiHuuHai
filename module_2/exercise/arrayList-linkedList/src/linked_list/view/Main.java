package linked_list.view;

import linked_list.controller.ProductController;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    static ProductController productController = new ProductController();

    public static void main(String[] args) {
        productController.displayMenu();
    }
}