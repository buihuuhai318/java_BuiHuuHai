import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter height: ");
                    int h = input.nextInt();
                    System.out.print("Enter weight: ");
                    int w = input.nextInt();
                    for (int i = 0; i < h; i++) {
                        for (int j = 0; j < w; j++) {
                            System.out.print("*  ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
                case 2 -> {
                    System.out.print("Enter height: ");
                    int h2 = input.nextInt();
                    int choice2 = -1;
                    while (choice2 != 0) {
                        System.out.println("1. top-left");
                        System.out.println("2. top-right");
                        System.out.println("3. botton-left");
                        System.out.println("4. botton-right");
                        System.out.println("0. Exit");
                        System.out.print("Enter choice: ");
                        choice2 = input.nextInt();

                        switch (choice2) {
                            case 1 -> {
                                for (int i = h2; i > 0; i--) {
                                    for (int j = 0; j < i; j++) {
                                        System.out.print("*  ");
                                    }
                                    System.out.println();
                                }
                                System.out.println();
                            }
                            case 2 -> {
                                for (int i = h2; i > 0; i--) {
                                    for (int j = 0; j <= h2; j++) {
                                        if (j <= h2 - i) {
                                            System.out.print("   ");
                                        } else {
                                            System.out.print("*  ");
                                        }
                                    }
                                    System.out.println();
                                }
                                System.out.println();
                            }
                            case 3 -> {
                                for (int i = 0; i < h2; i++) {
                                    for (int j = 0; j <= i; j++) {
                                        System.out.print("*  ");
                                    }
                                    System.out.println();
                                }
                                System.out.println();
                            }
                            case 4 -> {
                                for (int i = 0; i < h2; i++) {
                                    for (int j = 0; j <= h2; j++) {
                                        if (j < h2 - i) {
                                            System.out.print("   ");
                                        } else {
                                            System.out.print("*  ");
                                        }
                                    }
                                    System.out.println();
                                }
                                System.out.println();
                            }
                            case 0 -> {}
                            default -> System.out.println("No choice!");
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Enter height: ");
                    int h3 = input.nextInt();
                    for (int i = 0; i < h3; i++) {
                        for (int j = 0; j < h3 * 2; j++) {
                            if (j >= h3 - i && j <= h3 + i) {
                                System.out.print("*  ");
                            } else {
                                System.out.print("   ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
                case 0 -> System.exit(0);
                default -> System.out.println("No choice!");
            }
        }
    }
}