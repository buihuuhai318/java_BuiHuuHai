package bai1;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 3};
        System.out.println(checkArr(arr));
    }

    public static boolean checkArr(int[] arr) {
        Map<Integer, Integer> num = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (num.containsKey(arr[i])) {
                int count = num.get(arr[i]) + 1;
                num.put(arr[i], count);
            } else {
                num.put(arr[i], 1);
            }
        }
        int holder = num.get(arr[0]);
        for (Map.Entry<Integer, Integer> entry : num.entrySet()) {
            if (entry.getValue() != holder) {
                return false;
            }
        }
        return true;
    }
}