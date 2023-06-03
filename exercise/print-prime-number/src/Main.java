import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter amount of prime: ");
        int amount = input.nextInt();

        int countOfPrime = 0;
        int number = 2;

        while (countOfPrime < amount) {
            int count = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                countOfPrime ++;
                System.out.println(number);
            }
            number++;
        }
    }
}
