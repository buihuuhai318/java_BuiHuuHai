package bai8;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        int[] child = {1,2,3};
        int[] parent = {1,4,5,2,3,2,3,1};
        System.out.println(check(parent, child));
    }

    public static int check(int[] parent, int[] child) {
        Map<Integer, Integer> arr = new TreeMap<>();
        for (int i = 0; i < child.length; i++) {
            for (int j = 0; j < parent.length; j++) {
                if (child[i] == parent[j]) {
                    if (arr.containsKey(child[i])) {
                        int countHolder = arr.get(child[i]) + 1;
                        arr.put(child[i], countHolder);
                    } else {
                        arr.put(child[i], 1);
                    }
                }
            }
        }
        int min;
        if (arr.size() == child.length) {
            min = arr.get(child[0]);
            for (Map.Entry<Integer, Integer> entry : arr.entrySet()) {
                if (min > entry.getValue()) {
                    min = entry.getValue();
                }
            }
            return min;
        } else {
            return 0;
        }
    }
}
