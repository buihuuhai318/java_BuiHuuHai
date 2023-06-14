package repository.student;

import model.Student;

public interface IStudentRepository {
    void addNew(Student student);

    void remove(int id);
}
