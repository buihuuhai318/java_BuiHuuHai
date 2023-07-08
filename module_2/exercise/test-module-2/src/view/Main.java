package view;

import controller.BikeController;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    static public void main(String[] args) {
        BikeController controller = new BikeController();
        controller.displayMenu();
    }
}