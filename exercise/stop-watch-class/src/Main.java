import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StopWatch test = new StopWatch();
        Scanner input = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("1. get start time");
            System.out.println("2. get end time");
            System.out.println("3. get elapsed time");
            System.out.println("4. test loop");
            System.out.println("5. exit");
            System.out.print("your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    test.star();
                    System.out.println("now this star millis time is: " + test.getStartTime());
                }

                case 2 -> {
                    test.stop();
                    System.out.println("now this end millis time is: " + test.getEndTime());
                }

                case 3 -> System.out.println("elapsed time is: " + test.getElapsedTime());
                case 4 -> {
                    int[] arrNumber = new int[100000];
                    for (int i = 0; i < arrNumber.length; i++) {
                        arrNumber[i] = (int) (Math.random()*100000);
                    }
                    int box;
                    test.star();
                    for (int i = 0; i < arrNumber.length; i++) {
                        for (int j = i + 1; j < arrNumber.length; j++) {
                            if (arrNumber[i] < arrNumber[j]) {
                                box = arrNumber[i];
                                arrNumber[i] = arrNumber[j];
                                arrNumber[j] = box;
                            }
                        }
                    }
                    test.stop();
                    System.out.println("elapsed time is: " + test.getElapsedTime());
                }
                case 5 -> System.exit(0);
                default -> System.out.println("again");
            }
        }
    }
}