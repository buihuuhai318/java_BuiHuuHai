package test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] num = {8, 8, 8, 8};
        System.out.println(check(num));

    }

    public static int check(int[] num) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = num[0];
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], 1);
            if (max < num[i]) {
                max = num[i];
            }
        }
        System.out.println(map);
        map.remove(max);
        if (map.isEmpty()) {
            return -1;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = entry.getKey();
            break;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max < entry.getKey()) {
                max = entry.getKey();
            }
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] == max) {
                return i;
            }
        }
        return -1;
    }
}
