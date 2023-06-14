package repository.teacher;

import model.Teacher;

public interface ITeacherRepository {
    void addNew(Teacher teacher);

    void remove(int id);
}
