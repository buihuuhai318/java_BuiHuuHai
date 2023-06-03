import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nhập sô bạn muốn đọc");
        int num = sc.nextInt();

        int sX100 = num/100;

        if (num < 100) {
            System.out.println(numLessThan100(num));
        } else if (num < 1000) {
            System.out.println(numLessThan100(sX100) + " hundres and " + numLessThan100(num - sX100*100));
        }
    }

    public static String numLessThan100(int num) {
        String[] numOfStrX = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String[] numOfStr1X = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] numOfStrX10 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        int sX = num%10;

        String s;

        if (num <= 10) {
            s = numOfStrX[num];
        } else if (num < 20) {
            s = numOfStr1X[num - 10];
        } else {
            String sX10 = numOfStrX10[num / 10 - 2];
            switch (num) {
                case 20, 30, 40, 50, 60, 70, 80, 90 -> s = sX10;
                default -> s = sX10 + "-" + numOfStrX[sX];
            }
        }
        return s;
    }
}

