import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        String str = "s * ((s – a) * (s – b)) * (s – c)";

        System.out.println(checkBracket(str));
    }

    public static boolean checkBracket(String str) {
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x == '(' || x == ')') {
                if (temp.isEmpty()) {
                    temp.push(x);
                } else if (temp.get(0) == ')') {
                    return false;
                } else if (temp.get(0) == '(' && x == ')') {
                    temp.pop();
                } else {
                    temp.push(x);
                }
            }
        }
        return temp.isEmpty();
    }
}