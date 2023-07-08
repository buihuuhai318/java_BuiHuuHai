import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle);

        Scanner input = new Scanner(System.in);
        System.out.println("Tam giác khởi tạo có 3 cạnh a, b, c");
        System.out.print("Nhập cạnh a của tam giác: ");
        double a = input.nextDouble();
        System.out.print("Nhập cạnh b của tam giác: ");
        double b = input.nextDouble();
        System.out.print("Nhập cạnh c của tam giác: ");
        double c = input.nextDouble();
        input.nextLine();
        System.out.print("Nhập màu sắc của tam giác: ");
        String color = input.nextLine();

        triangle = new Triangle(a, b, c, color);
        System.out.println(triangle);
    }
}