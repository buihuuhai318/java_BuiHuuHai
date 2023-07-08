package service.interface_service;

import model.person.Employee;

public interface IEmployeeService extends IService {
    void edit();

    Employee changeValueEdit(Employee employee);

}
