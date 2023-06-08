public class Student extends Human {

    private static int studentCount = 0;

    private String room;
    private double score;

    public Student() {
        this.id = studentCount++;
    }

    public Student(String name, String date, boolean gender, String room, double score) {
        super(studentCount++, name, date, gender);
        this.room = room;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setScore(double score) {
        this.score = score;
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
                "ID", id, "Tên", name, "Ngày Sinh", date, "Giới Tính", sex, "Lớp", room, "Điểm", score);
    }
}
