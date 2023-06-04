import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] arr = {1,2,3,4,5,6,7,8,9,0};

        System.out.printf("%-12s\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\n","index");
        System.out.printf("%-14s","array\t");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();

        System.out.print("Nhập số cần xoá: ");
        int num = input.nextInt();

        System.out.printf("%-12s\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\n","index");
        System.out.printf("%-15s","before\t");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();

        int index = -1;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                index = i;
                flag = true;
            }
        }

        if (flag) {
            arr[index] = 0;
            for (int i = index + 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
            }
            System.out.printf("%-14s","after\t");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }
        } else {
            System.out.println("không tìm thấy");
        }

    }
}
