package ss1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhap so thu 1: ");
        double num1 = input.nextInt();
        System.out.println("nhap so thu 2: ");
        double num2 = input.nextInt();
        System.out.println("1. cong\n" +
                "2. tru\n" +
                "3. nhan\n" +
                "4. chia\n");
        System.out.println("chon phep tinh toan");
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> System.out.println(num1 + num2);
            case 2 -> System.out.println(num1 - num2);
            case 3 -> System.out.println(num1 * num2);
            case 4 -> System.out.println(num1 / num2);
            default -> System.out.println("nhap sai");
        }
    }
}