import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] arr = {1,2,3,4,0,0};

        System.out.print("nhập vị trí cần chèn (0 -> 5): ");
        int index = input.nextInt();

        if (index < 0 || index > arr.length - 1) {
            System.out.println("không chèn được");
        } else {
            System.out.print("nhập giá trị cần chèn: ");
            int num = input.nextInt();

            System.out.printf("%-12s", "after");
            for (int j : arr) {
                System.out.print(j + "\t");
            }
            System.out.println();

            for (int i = arr.length - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = num;

            System.out.printf("%-12s", "before");
            for (int j : arr) {
                System.out.print(j + "\t");
            }
        }
    }
}
