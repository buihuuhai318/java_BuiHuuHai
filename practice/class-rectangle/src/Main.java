import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the width: ");
        double width = input.nextDouble();
        System.out.print("Enter the height: ");
        double height = input.nextDouble();

        Rectangle rec = new Rectangle(height, width);

        System.out.println("Your Rectangle \n"+ rec.display());
        System.out.println("Perimeter of the Rectangle: "+ rec.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rec.getArea());
    }
}