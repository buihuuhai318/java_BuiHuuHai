public class Main {

    public static final String[] validTeleNum = new String[]{"(84)-(0978489648)", "(84)-(0942409424)"};
    public static final String[] invalidTeleNum = new String[]{"(a8)-(22222222)", "(84)-(9978489648)", "(84)-(22b22222)"};

    public static void main(String[] args) {

        ValidateTeleNumber validateTeleNumber = new ValidateTeleNumber();

        for (String num : validTeleNum) {
            boolean isValid = validateTeleNumber.validate(num);
            System.out.println("num is " + num + " is valid: " + isValid);
        }

        for (String num : invalidTeleNum) {
            boolean isValid = validateTeleNumber.validate(num);
            System.out.println("num is " + num + " is valid: " + isValid);
        }
    }
}