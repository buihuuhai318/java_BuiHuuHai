import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap do dai mang");
        int n = scanner.nextInt();
        int[] name = new int[n];

        for (int i = 0; i <n; i++) {
            System.out.print("nhap so thu " + i + " ");
            name[i] = scanner.nextInt();
        }


        System.out.println("mang vua tao la: ");
        show(name);


    }
    public static void show(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("phan tu thu " + i + " la: " + arr[i]);
        }
    }
}