package repository.student;

import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static view.Main.input;

public class StudentRepository implements IStudentRepository {
    public static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("Hải", "11/22/3333", true, "C0423G1", 8));
        students.add(new Student("Sang", "11/22/3333", true, "C0423G1", 8));
        students.add(new Student("Thiện", "11/22/3333", true, "C0423G1", 8));
        students.add(new Student("Nguyên", "11/22/3333", true, "C0423G1", 8));
    }

    @Override
    public void addNew(Student student) {
        students.add(student);
        System.out.println("\n----- Done -----");
    }

    @Override
    public void remove(int id) {
        System.out.println(students.get(id));
        input.nextLine();
        System.out.print("Xác Nhận Xoá:\n - yes = đồng ý / anykey = cancel : ");
        String answer = input.nextLine().toLowerCase();
        if (Objects.equals(answer, "yes")) {
            students.remove(id);
            System.out.println("------ DONE ------");
        } else {
            System.out.println("------ CANCEL ------");
        }
    }
}
