import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int num = 30;
        int num1 = num;
        int count = 1;
        while (num != 1) {
            num = num / 2;
            count++;
        }
        System.out.println(count);
        Stack<Integer> number = new Stack<>(count);
        for (int i = 0; i < count; i++) {
            number.push(num1 % 2);
            num1 = num1 / 2;
        }
        System.out.println(Arrays.toString(number.getArray()));
    }
}