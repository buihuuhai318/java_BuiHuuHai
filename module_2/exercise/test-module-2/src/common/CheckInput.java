package common;


import static view.Main.input;

public class CheckInput {
    public static int inputInt() {
        int num;
        try {
            num = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("--------Input Wrong--------");
            return inputInt();
        }
        return num;
    }

    public static String checkIdBike() {
        String num;
        final String REGEX_BIKE_ID = "^PT-[0-9]{3}$";
        try {
            num = input.nextLine();
            if (!num.matches(REGEX_BIKE_ID)) {
                System.out.println("Nhập sai định dạng");
                return checkIdBike();
            }
        } catch (Exception e) {
            System.out.println("--------Input Wrong--------");
            return checkIdBike();
        }
        return num;
    }
}
