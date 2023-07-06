package bai3;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        String str = "1, 2, 3, 3, 6, 5";
        System.out.println(check(str));
        Integer a = new Integer(2);
        Integer b = new Integer(2);
        System.out.println(a==b);
    }

    public static boolean check(String str) {
        String[] array = str.split(",");
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = Integer.parseInt(array[i].trim());
        }
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                sumLeft += newArray[j];
            }
            for (int j = i + 1; j < array.length; j++) {
                sumRight += newArray[j];
            }
            if (sumLeft == sumRight) {
                return true;
            } else {
                sumLeft = 0;
                sumRight = 0;
            }
        }
        return false;
    }
}
