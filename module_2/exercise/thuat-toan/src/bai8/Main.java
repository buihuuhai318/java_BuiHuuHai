package bai8;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        int[] child = {1,2,3};
        int[] parent = {1,4,5,2,3,2,3,1};
//        System.out.println(check(parent, child));
//        System.out.println(solve("1 4 5 2 1", "1 2 3"));
//        System.out.println( (125*125*125*125*125)%29 );
        System.out.println(solve(125, 5, 29));
    }

    public static int solve(int B, int P, int M) {
        if (M == 1) {
            return 0;
        }

        int result = 1;
        B %= M;

        System.out.println(B);

        while (P > 0) {
            System.out.println(P);
            if (P % 2 == 1) {
                result = (result * B) % M;
                System.out.println(result);
            }
            P /= 2;
            System.out.println(P);
            B = (B * B) % M;
            System.out.println(B);
        }

        return result;
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

    public static String solve(String parentString, String childString) {
        String[] parent = parentString.split(" ");
        String[] child = childString.split(" ");
        Map<String, Integer> arr = new TreeMap<>();
        for (int i = 0; i < child.length; i++) {
            for (int j = 0; j < parent.length; j++) {
                if (child[i].equals(parent[j])) {
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
            for (Map.Entry<String, Integer> entry : arr.entrySet()) {
                if (min > entry.getValue()) {
                    min = entry.getValue();
                }
            }
            return String.valueOf(min);
        } else {
            return "0";
        }

    }
}
