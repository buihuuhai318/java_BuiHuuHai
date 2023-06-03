import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float wight;
        float height;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter wight: ");
        wight = scanner.nextFloat();

        System.out.println("Enter height: ");
        height = scanner.nextFloat();

        float area = wight * height;
        System.out.println("Area is: " + area);
    }
}