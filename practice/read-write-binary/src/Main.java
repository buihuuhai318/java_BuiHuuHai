import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeDataToFile("student.txt", students);
        List<Student> listStudentFromData = readDataFromFile("student.txt");
        for (Student student : listStudentFromData) {
            System.out.println(student);
        }
    }

    public static void writeDataToFile(String path, List<Student> students) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(students);
            fileOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            students = (List<Student>) inputStream.readObject();
            fileInputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}