package com.example.team1.repository.employee;

import com.example.team1.model.accounts.Accounts;
import com.example.team1.model.employee.Employees;
import com.example.team1.repository.Base;
import com.example.team1.repository.accounts.AccountRepository;
import com.example.team1.repository.accounts.IAccountRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String INSERT = "insert into employees (employee_name, employee_salary, employee_gender, employee_birthday, employee_phone, employee_address, employee_image, account_id) values (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "select * from employees where employee_id = ?;";
    private static final String SELECT_ALL = "select * from employees";
    private static final String DELETE = "update employees set employee_status = 1 where employee_id = ?";
    private static final String AVAILABLE = "update employees set employee_status = 0 where employee_id = ?";
    private static final String UPDATE = "update employees set " +
            "employee_name = ?, " +
            "employee_salary = ?, " +
            "employee_gender = ?, " +
            "employee_birthday = ?, " +
            "employee_phone = ?, " +
            "employee_address = ?, " +
            "employee_image = ?, " +
            "employee_status = ? " +
            "where employee_id = ?";

    IAccountRepository accountRepository = new AccountRepository();
    @Override
    public void insertEmployee(Employees employees) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, employees.getName());
            preparedStatement.setInt(2, employees.getSalary());
            preparedStatement.setInt(3, employees.getGender());
            preparedStatement.setString(4, employees.getBirthday());
            preparedStatement.setString(5, employees.getPhone());
            preparedStatement.setString(6, employees.getAddress());
            preparedStatement.setString(7, employees.getImage());
            preparedStatement.setInt(8, employees.getAccount().getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employees selectEmployee(int id) {
        return selectAllEmployee().get(id);
    }

    @Override
    public Map<Integer, Employees> selectAllEmployee() {
        Map<Integer, Employees> employeesMap = new HashMap<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                int salary = resultSet.getInt("employee_salary");
                int gender = resultSet.getInt("employee_gender");
                String birthday = resultSet.getString("employee_birthday");
                String phone = resultSet.getString("employee_phone");
                String address = resultSet.getString("employee_address");
                int status = resultSet.getInt("employee_status");
                String image = resultSet.getString("employee_image");
                int accountId = resultSet.getInt("account_id");

                employeesMap.put(id, new Employees(id, name, salary, gender, birthday, phone, address, status, image, accountRepository.selectAccount(accountId)));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeesMap;
    }

    @Override
    public Map<String, Employees> selectAllEmployeeByEmail() {
        Map<String, Employees> employeesMap = new HashMap<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                int salary = resultSet.getInt("employee_salary");
                int gender = resultSet.getInt("employee_gender");
                String birthday = resultSet.getString("employee_birthday");
                String phone = resultSet.getString("employee_phone");
                String address = resultSet.getString("employee_address");
                int status = resultSet.getInt("employee_status");
                String image = resultSet.getString("employee_image");
                int accountId = resultSet.getInt("account_id");
                Accounts accounts = accountRepository.selectAccount(accountId);

                employeesMap.put(accounts.getEmail(), new Employees(id, name, salary, gender, birthday, phone, address, status, image, accounts));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeesMap;
    }

    @Override
    public void setAvailableEmployee(int id, boolean available) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement;
            if (available) {
                preparedStatement = connection.prepareStatement(AVAILABLE);
                preparedStatement.setInt(1, id);
            } else {
                preparedStatement = connection.prepareStatement(DELETE);
                preparedStatement.setInt(1, id);
            }
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEmployee(int id, Employees employees) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, employees.getName());
            preparedStatement.setInt(2, employees.getSalary());
            preparedStatement.setInt(3, employees.getGender());
            preparedStatement.setString(4, employees.getBirthday());
            preparedStatement.setString(5, employees.getPhone());
            preparedStatement.setString(6, employees.getAddress());
            preparedStatement.setString(7, employees.getImage());
            preparedStatement.setInt(8, employees.getStatus());
            preparedStatement.setInt(9, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
