package bai12;

import java.util.HashMap;
import java.util.Map;

public class New {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 4};
        System.out.println(check(arr));
    }

    public static int check(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        System.out.println(map);

        int count = 0;

        count = map.get(4);
        count += map.get(3);
        if (map.get(3) >= map.get(1)) {
            if ((map.get(2) * 2 + map.get(1)) % 4 == 0) {
                count += (map.get(2) * 2 + map.get(1)) / 4;
            } else {
                count += (map.get(2) * 2 + map.get(1)) / 4 + 1;
            }
        } else {
            int count1 = map.get(1) - map.get(3);
            if ((map.get(2) * 2 + count1) % 4 == 0) {
                count += (map.get(2) * 2 + count1) / 4;
            } else {
                count += (map.get(2) * 2 + count1) / 4 + 1;
            }
        }

        return count;
    }
}
