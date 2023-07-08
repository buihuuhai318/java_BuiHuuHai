import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("according to form: aX2 + bX + c = 0");
        Scanner input = new Scanner(System.in);

        System.out.print("enter a: ");
        double a = input.nextDouble();
        System.out.print("enter b: ");
        double b = input.nextDouble();
        System.out.print("enter c: ");
        double c = input.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        if (equation.getDiscriminant() > 0) {
            System.out.println("this equation has 2 root: ");
            System.out.print("root 1: " + equation.getRoot1() + "\n");
            System.out.print("root 2: " + equation.getRoot2());
        } else if (equation.getDiscriminant() == 0) {
            System.out.println("this equation has 1 root: ");
            System.out.print("root: " + equation.getRoot1() + "\n");
        } else {
            System.out.println("this equation has no root");
        }
    }
}