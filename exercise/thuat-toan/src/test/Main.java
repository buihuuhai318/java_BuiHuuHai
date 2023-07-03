package test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] str = {"iphone 14", "iphone 13 pro max", "iphone 12 pro max", "samsung filip", "samsung sida", "iphone sida"};
        System.out.println(Arrays.toString(check(str)));
    }

    public static String[] check(String[] str) {
        System.out.println("nhap ten muon tim kiem");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        List<String> stringList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].contains(name)) {
                count++;
                stringList.add(str[i]);
            }
        }
        int index = 0;
        String[] newStr = new String[count];
        for (int i = 0; i < newStr.length; i++) {
            newStr[i] = stringList.get(i);
        }
        return newStr;
    }
}
