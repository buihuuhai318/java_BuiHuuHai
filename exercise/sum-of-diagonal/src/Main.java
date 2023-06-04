import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("nhập độ dài của ma trận: ");
        int h = input.nextInt();


        int[][] arr = new int[h][h];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("nhập phần tử tại vị trí [%d][%d]: ",i ,j);
                arr[i][j] = input.nextInt();
            }
        }

        System.out.printf("%-10s\t0\t2\t3\t4\t5\t6\t7\t8\t9\n", "index: ");
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-5s%-7d", "cow",i);
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf(arr[i][j] + "\t");
                if (i == j) {
                    sum += arr[i][j];
                }
            }
            System.out.println();
        }


        System.out.println("giá trị tổng của đường chéo chính là: " + sum);
    }
}