package service.teacher;

public interface ITeacherService {
    void addNew();

    void remove(int id);

    void display();

    int searchId(int id);
}
