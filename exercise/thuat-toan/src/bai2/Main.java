package bai2;

public class Main {
    public static void main(String[] args) {
        String s1 = "Abcdef";
        String s2 = "Adghjklbc";
        System.out.println(checkArr(s1, s2));
    }

    public static int checkArr(String s1, String s2) {
        StringBuilder stringBuilder = new StringBuilder(s2);
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < stringBuilder.length(); j++) {
                if (s1.charAt(i) == stringBuilder.charAt(j)) {
                    stringBuilder.delete(j, j + 1);
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
