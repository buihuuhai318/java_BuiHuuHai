package view;

import controller.BookController;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        BookController controller = new BookController();
        controller.displayMenu();
    }
}