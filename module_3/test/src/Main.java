import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("abbb");
        list.add("aab");
        list.add("ba");
        list.add("aa");
        list.add("baaa");
        System.out.println(solve(5));
    }

    public static int solve(int a) {
        int lastNonZeroDigit = 1;

        for (int i = 1; i <= a; i++) {
            lastNonZeroDigit = (lastNonZeroDigit * i);
            System.out.println(lastNonZeroDigit);

            while (lastNonZeroDigit % 10 == 0) {
                if (lastNonZeroDigit < 10) {
                    break;
                }
                lastNonZeroDigit /= 10;
                System.out.println(lastNonZeroDigit);
            }
        }
        int count = lastNonZeroDigit / 10;
        lastNonZeroDigit = lastNonZeroDigit - count * 10;
        return lastNonZeroDigit;
    }
}