package bai22;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(check(12)));
    }

    public static boolean isPrime(int a) {
        int count = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                count++;
            }
        }
        return count==2;
    }

    public static int[] check(int a) {
        int[] array = new int[2];
        int b = 0;
        for (int i = 2; i < a; i++) {
            if (isPrime(i)) {
                b =  a - i;
                if (isPrime(b)) {
                    array[0] = i;
                    array[1] = b;
                    return array;
                }
            }
        }
        return array;
    }
}
