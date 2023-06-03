import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vnd = 23000;
        double usd;

        System.out.println("Nhập số tiền USD: ");
        usd = scanner.nextDouble();

        double change = usd * vnd;
        System.out.println("giá trị quy đổi từ USD sang VND");

        System.out.printf("%-20s%s", "usd", "change\n");
        System.out.printf("%-20s%s", usd, change);
    }
}
