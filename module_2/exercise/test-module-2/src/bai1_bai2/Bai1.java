package bai1_bai2;

public class Bai1 {
    public static void main(String[] args) {
        String str = "hai codegym";
        int start = 8;
        int end = 10;
        System.out.println(toSubString(str, start, end));
    }

    public static String toSubString(String str, int start, int end) {
        String result = "";
        if (start >= 0 && end < str.length()) {
            for (int i = start; i < end; i++) {
                result += str.charAt(i);
            }
        }
        return result;
    }
}
