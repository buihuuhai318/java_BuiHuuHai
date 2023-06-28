package bai9;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 30;
        System.out.println(check(a, b));
    }

    public static int check(int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i >= 10) {
                int c = i / 10;
                int numFirst = i / (10 * c);
                int numLast = i % 10;
                if (numLast == numFirst) {
                    count++;
                }
            } else {
                count++;
            }
        }
        return count;
    }
}
