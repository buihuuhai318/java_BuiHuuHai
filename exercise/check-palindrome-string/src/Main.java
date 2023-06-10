import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("enter your string need to check: ");
        String str = input.nextLine();

        Queue queue = new LinkedList();

        for (int i = str.length() - 1; i >= 0; i--) {
            queue.add(str.charAt(i));
        }

        String reverseStr = "";

        while (!queue.isEmpty()) {
            reverseStr += queue.remove();
        }

        if (str.equals(reverseStr)) {
            System.out.println("this is Palindrome string");
        } else {
            System.out.println("this is not Palindrome string");
        }
    }
}