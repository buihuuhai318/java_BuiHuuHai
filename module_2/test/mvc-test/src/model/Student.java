package model;

public class Student extends Person {

    private static  int countStudent = 1;
    private String className;

    private int point;
    public Student() {
        super.id = countStudent++;
    }

    public Student(String className, int point) {
        super.id = countStudent++;
        this.className = className;
        this.point = point;
    }

    public Student(String name, boolean gender, String date, String className, int point) {
        super(name, gender, date);
        super.id = countStudent++;
        this.className = className;
        this.point = point;
    }

    @Override
    public String toString() {
        String sex;
        if (gender) {
            sex = "nam";
        } else {
            sex = "nữ";
        }
        return String.format(
                "| %s: %-3d | %s: %-10s | %s: %-10s | %s: %-5s | %s: %-8s | %s: %-5s|",
                "ID", id, "Tên", name, "Ngày Sinh", date, "Giới Tính", sex, "Lớp", className, "Điểm", point);
    }
}
