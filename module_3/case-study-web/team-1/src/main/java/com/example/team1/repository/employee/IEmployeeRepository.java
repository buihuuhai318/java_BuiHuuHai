package com.example.team1.repository.employee;

import com.example.team1.model.employee.Employees;

import java.util.Map;

public interface IEmployeeRepository {
    void insertEmployee(Employees employees);

    Employees selectEmployee(int id);

    Map<Integer, Employees> selectAllEmployee();
    public Map<String, Employees> selectAllEmployeeByEmail();

    void deleteEmployee(int id, boolean available);

    void updateEmployee(int id, Employees employees);
}
