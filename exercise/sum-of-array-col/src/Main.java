import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("nhập số hàng của mảng: ");
        int row = input.nextInt();

        int[][] arr = new int[row][];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("nhập số cột của mảng thứ " + i + ": ");
            int col = input.nextInt();
            arr[i] = new int[col];
            for (int j = 0; j < col; j++) {
                System.out.printf("nhập phần tử tại vị trí [%d][%d]: ",i ,j);
                arr[i][j] = input.nextInt();
            }
        }

        System.out.printf("%-10s\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\n", "index: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-5s%-7d", "cow",i);
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf(arr[i][j] + "\t");
            }
            System.out.println();
        }

        do {
            System.out.println("- nhập -1 để exit");
            System.out.print("- nhập index cột bạn muốn tính tổng: ");
            int colOfArr = input.nextInt();
            if (colOfArr == -1) {
                System.exit(0);
            } else {
                int sum = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (colOfArr < arr[i].length) {
                        sum += arr[i][colOfArr];
                    }
                }
                System.out.printf("- giá trị tổng của cột %d là: %d\n", colOfArr, sum);
            }
        } while (true);

    }
}