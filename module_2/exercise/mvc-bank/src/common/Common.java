package common;

import static view.Main.input;

public class Common {
    public static int inputInt() {
        try {
            int num = Integer.parseInt(input.nextLine());
            return inputInt();
        } catch (Exception e) {
            return inputInt();
        }
    }
}
