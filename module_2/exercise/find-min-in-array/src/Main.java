import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("nhập chiều dài mảng: ");
        int length = input.nextInt();

        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("nhập phần tử tại vị trí [%d]: ",i);
            arr[i] = input.nextInt();
        }

        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println();
        System.out.println("số nhỏ nhất trong mảng là: " + min);


    }
}