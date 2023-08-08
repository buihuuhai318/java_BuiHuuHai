package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test1 {

    public static int solve(int n, List<Integer> a) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            int count = 1;
            int temp = a.get(i);
            for (int j = 0; j < a.size(); j++) {
                if (a.get(j) > temp) {
                    temp = a.get(j);
                    count++;
                }
            }
            list.add(count);
        }
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }
        return max;
    }









    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> listLine = new ArrayList<>();
        list.add("an");
        list.add("anh");
        list.add("hai");
        list.add("ai");
        list.add("toi");
        list.add("toia");
        listLine.add("anhai");
        listLine.add("haian");
        listLine.add("aianh");
        listLine.add("toiha");
        listLine.add("toiaiha");

        System.out.println(solve(6, list, 5, listLine));





    }
}
