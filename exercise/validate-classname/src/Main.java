public class Main {

    public static final String[] validClassName = new String[]{"C0223G", "C0223G"};
    public static final String[] invalidClassName = new String[]{"M0318G", "P0323A"};

    public static void main(String[] args) {
        ValidateClassName validateClassName = new ValidateClassName();

        for (String name : validClassName) {
            boolean isValid = validateClassName.validate(name);
            System.out.println("name is " + name + " is valid: " + isValid);
        }

        for (String name : invalidClassName) {
            boolean isValid = validateClassName.validate(name);
            System.out.println("name is " + name + " is valid: " + isValid);
        }
    }
}