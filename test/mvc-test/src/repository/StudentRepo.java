package repository;

import model.Student;

import java.util.ArrayList;
import java.util.List;

import static view.Main.input;

public class StudentRepo implements IStudentRepo {
    static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student("thoi", true, "22/22/22", "c04", 5));
        studentList.add(new Student("sang", true, "22/22/22", "c04", 5));
        studentList.add(new Student("thien", true, "22/22/22", "c04", 5));

    }

    @Override
    public void addNew(Student student) {
        studentList.add(student);
    }

    @Override
    public void remove(int index) {
        System.out.println(studentList.get(index));
        System.out.println("yes no");
        String anwser = input.nextLine().toLowerCase();
        if (anwser.equals("yes")) {
            studentList.remove(index);
        } else {
            System.out.println("cancel");
        }
    }

    @Override
    public List<Student> display() {
        return studentList;

    }

    @Override
    public int searchId(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
