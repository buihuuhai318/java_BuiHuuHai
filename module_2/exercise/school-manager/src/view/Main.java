package view;

import controller.ControllerSchool;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    static ControllerSchool controller = new ControllerSchool();

    public static void main(String[] args) {
        controller.menu();
    }
}