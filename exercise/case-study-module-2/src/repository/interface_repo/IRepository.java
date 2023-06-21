package repository.interface_repo;

public interface IRepository<E> {
    void addNew(E e);

    void display();

    E getElement(int index);
    int checkID(String id);
}
