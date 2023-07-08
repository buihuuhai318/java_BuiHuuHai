package model;

public class Teacher extends Human {
    private String major;

    static int teacherCount = 0;

    public Teacher() {
        this.id = teacherCount++;
    }

    public Teacher(String name, String date, boolean gender, String major) {
        super(teacherCount++, name, date, gender);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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
                "| %s: %-3d | %s: %-10s | %s: %-10s | %s: %-5s | %s: %-8s |",
                "ID", id, "Tên", name, "Ngày Sinh", date, "Giới Tính", sex, "Chuyên Môn", major);
    }
}
