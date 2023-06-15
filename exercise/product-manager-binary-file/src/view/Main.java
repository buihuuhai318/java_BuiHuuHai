package view;

import controller.ProductController;

import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static ProductController productController = new ProductController();


    public static void main(String[] args) {
        productController.display();
    }
}