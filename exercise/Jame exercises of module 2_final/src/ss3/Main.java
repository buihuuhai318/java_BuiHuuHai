package ss3;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        bai3();

    }

    public static void bai1() {
        System.out.println("nhap 1 so nguyen bat ky: ");
        int num = input.nextInt();
        int index = -1;
        int[] arr = {1,2,3,4,5,6,7,1,2,3};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                index = i;
            }
        }
        if (index != -1) {
            System.out.println("vi tri cua so " + num + " la: " + index);
        } else {
            System.out.println("so " + num + " khong co trong mang");
        }
    }

    public static void bai2() {
        System.out.print("nhap do dai mang: ");
        int length = input.nextInt();
        int[] nums = new int[length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.print("nhap so o vi tri " + i + " : ");
            nums[i] = input.nextInt();
            if (i % 2 != 0) {
                sum += i;
            }
        }
        System.out.println("tong cac so nguyen o vi tri le la: " + sum);
    }

    public static void bai3() {
        System.out.println("nhap do dai mang");
        int m = input.nextInt();
        int n;
        int sum = 0;
        int count = 0;
        int[][] nums = new int[m][];
        for (int i = 0; i < nums.length; i++) {
            System.out.print("nhap chieu rong mang con thu " + i + " : ");
            n = input.nextInt();
            nums[i] = new int[n];
            for (int j = 0; j < nums[i].length; j++) {
                System.out.printf("nhap so thu [%s][%s] : ", i, j);
                nums[i][j] = input.nextInt();
                if (nums[i][j] % 2 == 0) {
                    sum += nums[i][j];
                    count++;
                }
            }
        }
        int avg = sum / count;
        System.out.println(avg);
    }
}
