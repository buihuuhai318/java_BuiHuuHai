package bai7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 43},
                {9, 4, 11, 7},
                {11, 6, 4, 0},
                {1, 2, 6, 51}
        };
        System.out.println(Arrays.toString(check(arr)));
    }

    public static int[] check(int[][] arr) {
        List<Integer> num = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (isPrime(arr[i][j]) && !num.contains(arr[i][j])) {
                    num.add(arr[i][j]);
                    count++;
                }
            }
        }
        int[] newArr = {};
        if (count > 0) {
            newArr = new int[count];
            Collections.sort(num);
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = num.get(i);
            }
            return newArr;
        } else {
            return newArr;
        }

    }

    public static boolean isPrime(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count == 2;
    }
}
