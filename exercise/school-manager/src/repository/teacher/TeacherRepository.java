package repository.teacher;

import model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static view.Main.input;

public class TeacherRepository implements ITeacherRepository {
    public static List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher("Quang", "11/22/3333", true, "Java"));
        teachers.add(new Teacher("Trung", "11/22/3333", true, "Java"));
        teachers.add(new Teacher("Hải", "11/22/3333", true, "Java"));
        teachers.add(new Teacher("Chánh", "11/22/3333", true, "Java"));
    }

    @Override
    public void addNew(Teacher teacher) {
        teachers.add(teacher);
        System.out.println("\n----- Done -----");
    }

    @Override
    public void remove(int id) {
        System.out.println(teachers.get(id));
        input.nextLine();
        System.out.print("Xác Nhận Xoá:\n - yes = đồng ý / anykey = cancel : ");
        String answer = input.nextLine().toLowerCase();
        if (Objects.equals(answer, "yes")) {
            teachers.remove(id);
            System.out.println("------ DONE ------");
        } else {
            System.out.println("------ CANCEL ------");
        }
    }
}
