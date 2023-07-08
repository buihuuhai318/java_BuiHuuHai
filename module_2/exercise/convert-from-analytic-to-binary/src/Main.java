import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int num = 30;
        int count = countOfBinary(num);

        Stack<Integer> number = new Stack<>(count);

        for (int i = 0; i < count; i++) {
            number.push(num % 2);
            num = num / 2;
        }

        System.out.println(number);
    }
    public static int countOfBinary(int num) {
        int count = 1;
        while (num != 1) {
            num = num / 2;
            count++;
        }
        return count;
    }
}