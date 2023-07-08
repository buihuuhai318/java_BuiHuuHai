import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = "Im Hai, Im living in Da Nang City";
        System.out.println(str);
        Scanner input = new Scanner(System.in);

        System.out.print("nhập ký tự bạn muốn tìm: ");
        char word = input.next().charAt(0);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == word) {
                count++;
            }
        }
        System.out.printf("ký tự %s được lặp lại %d lần", word, count);
    }
}