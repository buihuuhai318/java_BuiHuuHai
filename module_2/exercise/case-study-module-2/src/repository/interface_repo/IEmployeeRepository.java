package repository.interface_repo;

import model.person.Employee;

public interface IEmployeeRepository extends IRepository<Employee> {
    @Override
    void addNew(Employee employee);

    void edit(int index, Employee employee);

    void updateFile();
}
