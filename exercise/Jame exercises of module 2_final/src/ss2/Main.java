package ss2;

import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        bai1();
        bai2();
    }

    public static void bai1() {
        System.out.println("nhap 1 so bat ky: ");
        int num = input.nextInt();
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println("tong cac uoc so cua " + num + " la: " + sum);
    }

    public static void bai2() {
        System.out.println("nhap so thu 1: ");
        int num1 = input.nextInt();
        System.out.println("nhap so thu 2: ");
        int num2 = input.nextInt();
        int bcnn = num1 * num2;
        while (num1 != num2) {
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }
        int ucln = num1;
        bcnn = bcnn / ucln;
        System.out.println("UCLN = " + ucln + "\n" +
                "BCNN = " + bcnn + "\n" +
                "TCB = " + ((ucln + bcnn) / 2));
    }
}
