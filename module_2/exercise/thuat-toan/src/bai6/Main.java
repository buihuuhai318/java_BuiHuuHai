package bai6;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String s = "abcdab";
        System.out.println(Arrays.toString(checkStr(s)));
    }

    public static String[] checkStr(String s) {
        Map<Character, Integer> str = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (str.containsKey(s.charAt(i))) {
                int count = str.get(s.charAt(i)) + 1;
                str.put(s.charAt(i), count);
            } else {
                str.put(s.charAt(i), 1);
            }
        }
        String newStr = "";
        for (Map.Entry<Character, Integer> entry : str.entrySet()) {
            if (entry.getValue() > 1) {
                newStr += entry.getKey();
            }
        }
        return newStr.split("");
    }
}
