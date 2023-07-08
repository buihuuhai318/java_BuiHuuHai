package bai8;

import java.util.HashMap;
import java.util.Map;

public class New {
    public static void main(String[] args) {
        int[] parent = {4,1,4,5,2,3,2,3,8,3,3};
        int[] child = {1,2,3};
        System.out.println(check(parent, child));
    }
    public static int check(int[] parent, int[] child) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < child.length; i++) {
            for (int j = 0; j < parent.length; j++) {
                if (parent[j] == child[i]) {
                    if (!map.containsKey(child[i])) {
                        map.put(child[i], count);
                    }  else {
                        map.put(child[i], map.get(child[i]) + 1);
                    }
                }
            }
            count = 1;
        }
        int min = map.get(child[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (min > entry.getValue()) {
                min = entry.getValue();
            }
        }
        System.out.println(map);
        return min;
    }
}
