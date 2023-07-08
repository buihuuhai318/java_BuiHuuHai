package bai9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int a = 100;
        int b = 10000;
        System.out.println(check(a, b));
    }

    public static int check(int a, int b) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i >= 10) {
                int numFirst = i;
                while (numFirst >= 10) {
                    numFirst = numFirst / 10;
                }
                int numLast = i % 10;
                if (numLast == numFirst) {
                    count++;
                    list.add(i);
                }
            } else {
                count++;
            }
        }
        System.out.println(list);
        return count;
    }
}
