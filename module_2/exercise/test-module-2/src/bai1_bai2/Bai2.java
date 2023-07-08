package bai1_bai2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai2 {
    public static void main(String[] args) {
        int[] array = {12};
        System.out.println(checkArray(array));
    }

    public static int checkArray(int[] array) {
        List<Integer> arrayList = new ArrayList<>();
        boolean flag;
        int max;
        int index;
        for (int j : array) {
            arrayList.add(j);
        }
        while (true) {
            if (arrayList.isEmpty()) {
                return 0;
            } else {
                flag = true;
                max = arrayList.get(0);
                index = 0;
                for (int i = 0; i < arrayList.size(); i++) {
                    if (max < arrayList.get(i)) {
                        max = arrayList.get(i);
                        index = i;
                    }
                }
                String[] num = String.valueOf(max).split("");
                for (String s : num) {
                    int holder = Integer.parseInt(s);
                    if (holder % 2 == 0) {
                        flag = false;
                        arrayList.remove(index);
                        break;
                    }
                }
            }
            if (flag) {
                return max;
            }
        }
    }
}
