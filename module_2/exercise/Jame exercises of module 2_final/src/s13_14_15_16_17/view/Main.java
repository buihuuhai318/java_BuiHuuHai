package s13_14_15_16_17.view;

import s13_14_15_16_17.controller.Controller;

import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.menu();
    }
}
