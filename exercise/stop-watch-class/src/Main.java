import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StopWatch test = new StopWatch();
        Scanner input = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("1. get start time");
            System.out.println("2. get start millis");
            System.out.println("3. get end time");
            System.out.println("4. get end millis");
            System.out.println("5. get elapsed time");
            System.out.println("6. exit");
            System.out.print("your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1 -> System.out.println("now this star time is: " + test.star());
                case 2 -> System.out.println("now this star millis time is: " + test.getStartTime());
                case 3 -> System.out.println("now this end time is: " + test.stop());
                case 4 -> System.out.println("now this end millis time is: " + test.getEndTime());
                case 5 -> System.out.println("elapsed time is: " + test.getElapsedTime());
                case 6 -> System.exit(0);
                default -> System.out.println("again");
            }
        }
    }
}