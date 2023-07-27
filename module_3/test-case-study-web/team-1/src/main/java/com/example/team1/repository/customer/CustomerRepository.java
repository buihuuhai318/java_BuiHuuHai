package com.example.team1.repository.customer;

import com.example.team1.model.customers.Customers;
import com.example.team1.model.accounts.Accounts;
import com.example.team1.repository.Base;
import com.example.team1.repository.accounts.AccountRepository;
import com.example.team1.repository.accounts.IAccountRepository;

import java.sql.*;

import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class CustomerRepository implements ICustomerRepository {
    private static final String INSERT = "insert into customers (customer_name, customer_gender, customer_birthday, customer_phone, account_email, customer_address, customer_image, customer_type_id, account_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL = "select * from customers";
    private static final String DELETE = "update customers set customer_status = 1 where customer_id = ?";
    private static final String AVAILABLE = "update customers set customer_status = 0 where customer_id = ?";
    private static final String UPDATE = "update customers set " +
            "customer_name = ?, " +
            "customer_gender = ?, " +
            "customer_birthday = ?, " +
            "customer_phone = ?, " +
            "customer_image = ?, " +
            "customer_type_id = ?, " +
            "customer_status = ?, " +
            "customer_address = ? " +
            "where customer_id = ?";

    //    private static final String SELECT_BY_ID = "select * from customers where customer_id = ?;";

    IAccountRepository accountRepository = new AccountRepository();
    ITypeRepository typeRepository = new TypeRepository();

    @Override
    public void insertCustomer(Customers customers) {
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, customers.getName());
            preparedStatement.setInt(2, customers.isGender());
            preparedStatement.setString(3, customers.getBirthday());
            preparedStatement.setString(4, customers.getPhone());
            preparedStatement.setString(5, customers.getEmail());
            preparedStatement.setString(6, customers.getAddress());
            preparedStatement.setString(7, customers.getImage());
            preparedStatement.setInt(8, customers.getType().getId());
            preparedStatement.setInt(9, customers.getAccount().getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customers selectCustomer(int id) {
        return selectAllCustomer().get(id);
    }

    @Override
    public Map<Integer, Customers> selectAllCustomer() {
        Map<Integer, Customers> customersMap = new HashMap<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                int gender = resultSet.getInt("customer_gender");
                String birthday = resultSet.getString("customer_birthday");
                String phone = resultSet.getString("customer_phone");
                String address = resultSet.getString("customer_address");
                int status = resultSet.getInt("customer_status");
                String image = resultSet.getString("customer_image");
                int type = resultSet.getInt("customer_type_id");
                int accountId = resultSet.getInt("account_id");

                customersMap.put(id, new Customers(id, name, gender, birthday, phone, address, status, image, typeRepository.selectType(type), accountRepository.selectAccount(accountId)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customersMap;
    }

    @Override
    public Map<String, Customers> selectAllCustomerByEmail() {
        Map<String, Customers> customersMap = new HashMap<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                int gender = resultSet.getInt("customer_gender");
                String birthday = resultSet.getString("customer_birthday");
                String phone = resultSet.getString("customer_phone");
                String address = resultSet.getString("customer_address");
                int status = resultSet.getInt("customer_status");
                String image = resultSet.getString("customer_image");
                int type = resultSet.getInt("customer_type_id");
                int accountId = resultSet.getInt("account_id");
                Accounts accounts = accountRepository.selectAccount(accountId);
                customersMap.put(accounts.getEmail(), new Customers(id, name, gender, birthday, phone, address, status, image, typeRepository.selectType(type), accounts));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customersMap;
    }

    @Override
    public void deleteCustomer(int id, boolean available) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement;
            if (available) {
                preparedStatement = connection.prepareStatement(DELETE);
                preparedStatement.setInt(1, id);
            } else {
                preparedStatement = connection.prepareStatement(AVAILABLE);
                preparedStatement.setInt(1, id);
            }
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCustomer(int id, Customers customers) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, customers.getName());
            preparedStatement.setInt(2, customers.isGender());
            preparedStatement.setString(3, customers.getBirthday());
            preparedStatement.setString(4, customers.getPhone());
            preparedStatement.setString(5, customers.getImage());
            preparedStatement.setInt(6, customers.getType().getId());
            preparedStatement.setInt(7, customers.isStatus());
            preparedStatement.setString(8, customers.getAddress());
            preparedStatement.setInt(9, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
