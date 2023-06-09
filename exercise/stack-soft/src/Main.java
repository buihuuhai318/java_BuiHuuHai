
import java.util.Arrays;

import static java.lang.String.valueOf;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        reverse(arr);
        System.out.println(Arrays.toString(arr));

        StringBuffer str= new StringBuffer("bui huu hai");
        reverse(str);
        System.out.println(str);
    }
    public static void reverse(int[] array) {

        int n = array.length;
        Stack<Integer> num = new Stack<>(n);

        for (int i = 0; i < array.length; i++) {
            num.push(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = num.pop();
        }
    }
    public static void reverse(StringBuffer arrayStr) {

        int n = arrayStr.length();
        Stack<Character> str = new Stack<>(n);

        for (int i = 0; i < arrayStr.length(); i++) {
            str.push(arrayStr.charAt(i));
        }

        for (int i = 0; i < arrayStr.length(); i++) {
            char ch = str.pop();
            arrayStr.setCharAt(i,ch);
        }
    }

}