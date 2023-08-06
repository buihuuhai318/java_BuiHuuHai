package com.example.team1.service.employee;

import com.example.team1.model.employee.Employees;
import com.example.team1.repository.employee.EmployeeRepository;
import com.example.team1.repository.employee.IEmployeeRepository;

import java.util.Map;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public void insertEmployee(Employees employees) {
        employeeRepository.insertEmployee(employees);
    }

    @Override
    public Employees selectEmployee(int id) {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public Map<Integer, Employees> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    @Override
    public Map<String, Employees> selectAllEmployeeByEmail() {
        return employeeRepository.selectAllEmployeeByEmail();
    }

    @Override
    public void setAvailableEmployee(int id, boolean available) {
        employeeRepository.setAvailableEmployee(id, available);
    }

    @Override
    public void updateEmployee(int id, Employees employees) {
        employeeRepository.updateEmployee(id, employees);
    }
}
