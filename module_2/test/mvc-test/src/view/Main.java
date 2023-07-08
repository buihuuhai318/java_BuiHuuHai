package view;

import controller.Controller;

import java.util.Scanner;

public class Main {

    static public Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.menu();
    }
}