public class Student {
    private int id;
    private String name;
    public static String college = "FPT";

    Student(int r, String n) {
        id = r;
        name = n;
    }

    static void change() {
        college = "CODEGYM";
    }

    void display() {
        System.out.println(id + " " + name + " " + college);
    }
}
