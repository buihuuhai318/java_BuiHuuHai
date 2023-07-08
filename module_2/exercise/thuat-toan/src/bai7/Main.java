package bai7;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 43},
                {9, 4, 11, 7},
                {11, 6, 4, 0},
                {1, 2, 6, 51}
        };
        System.out.println(Arrays.toString(check(arr)));
        int[] newArr = check(arr);
    }

    public static int[] check(int[][] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (isPrime(arr[i][j])) {
                    set.add(arr[i][j]);
                }
            }
        }
        int[] newArr = new int[set.size()];
//        List<Integer> list = new ArrayList<>(set);
        int index = 0;
        for (Integer integer : set) {
            newArr[index] = integer;
            index++;
        }
//        for (int i = 0; i < newArr.length; i++) {
//            newArr[i] = list.get(i);
//        }
        return newArr;
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
