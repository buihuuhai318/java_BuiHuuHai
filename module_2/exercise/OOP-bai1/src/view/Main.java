package view;

import controller.CompanyController;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        CompanyController controller = new CompanyController();
        controller.displayMenu();
    }
}