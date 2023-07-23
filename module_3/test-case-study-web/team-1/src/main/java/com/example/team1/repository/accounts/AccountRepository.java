package com.example.team1.repository.accounts;

import com.example.team1.model.accounts.Accounts;
import com.example.team1.repository.Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AccountRepository implements IAccountRepository {

    private static final String INSERT = "insert into accounts (account_username, account_password, account_create_date, role_id) values (?, ?, ?, ?);";
    private static final String  SELECT_BY_ID = "select account_id, account_username, account_password, account_create_date, role_id from accounts where account_id = ?;";
    private static final String SELECT_ALL = "select * from accounts";
    private static final String DELETE = "update accounts set account_status = 1 where account_id = ?";
    private static final String UPDATE = "update accounts set account_password = ? where account_id = ?";

    @Override
    public void insertAccount(Accounts accounts) {
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, accounts.getUsername());
            preparedStatement.setString(2, accounts.getPassword());
            preparedStatement.setString(3, accounts.getCreateDate());
            preparedStatement.setInt(4, accounts.getRole());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Accounts selectAccount(int id) {
        Accounts accounts = null;
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String createDate = resultSet.getString("create-date");
                String role = resultSet.getString("role");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Map<String, Accounts> selectAllAccount() {
        Map<String, Accounts> accountsMap = new HashMap<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("account_id");
                String username = resultSet.getString("account_username");
                String password = resultSet.getString("account_password");
                String createDate = resultSet.getString("account_create_date");
                boolean accountStatus = Boolean.parseBoolean(resultSet.getString("account_status"));
                int roleId = resultSet.getInt("role_id");
                accountsMap.put(username, new Accounts(id, username, password, createDate, accountStatus, roleId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accountsMap;
    }

    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepository();
        System.out.println(accountRepository.selectAllAccount());
        System.out.println(accountRepository.checkLogin("admin", "123"));
        System.out.println(accountRepository.checkLogin("admin", "111"));
        System.out.println(accountRepository.checkLogin("admin123", "111"));
    }

    @Override
    public void deleteAccount(int id) {

    }

    @Override
    public void updateAccount(int id, Accounts accounts) {

    }

    @Override
    public boolean checkLogin(String username, String password) {
        Accounts accounts = selectAllAccount().get(username);
        if (accounts != null) {
            if (!accounts.isStatus()) {
                if (accounts.getPassword().equals(password)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
