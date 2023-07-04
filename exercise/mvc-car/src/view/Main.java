package view;

import controller.CarController;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        CarController controller = new CarController();
        controller.displayMenu();
    }
    
}