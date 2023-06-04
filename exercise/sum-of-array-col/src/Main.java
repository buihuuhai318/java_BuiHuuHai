import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("nhập số hàng của ma trận: ");
        int row = input.nextInt();
        System.out.print("nhập số cột của ma trận: ");
        int col = input.nextInt();

        int[][] arr = new int[row][col];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("nhập phần tử tại vị trí [%d][%d]: ",i ,j);
                arr[i][j] = input.nextInt();
            }
        }

        System.out.printf("%-10s\t0\t2\t3\t4\t5\t6\t7\t8\t9\n", "index: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-5s%-7d", "cow",i);
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.print("nhập số cột bạn muốn tính tổng: ");
        int sumOfCol = input.nextInt();
        int sum = 0;
        for (int i = 0; i < arr[sumOfCol - 1].length; i++) {
            sum += arr[i][sumOfCol - 1];
        }

        System.out.printf("giá trị tổng của cột %d là: %d",sumOfCol, sum);
    }
}