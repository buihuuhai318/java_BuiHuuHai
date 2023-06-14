package service.student;

public interface IStudentService {
    void addNew();

    void remove(int id);

    void display();

    int searchId(int id);
}
