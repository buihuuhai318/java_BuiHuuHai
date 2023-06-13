import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        System.out.print("Enter your string: ");
        String str = input.nextLine();
        list.add(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) < list.getLast() && list.size() > 1) {
                list.clear();
            }

            list.add(str.charAt(i));

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }
        
        for (Character character : max) {
            System.out.print(character);
        }
    }
}