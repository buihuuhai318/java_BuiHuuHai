package repository;

import model.Student;

import java.util.List;

public interface IStudentRepo {
    void addNew(Student student);
    void remove(int index);
    List<Student> display();
    int searchId(int id);
}
