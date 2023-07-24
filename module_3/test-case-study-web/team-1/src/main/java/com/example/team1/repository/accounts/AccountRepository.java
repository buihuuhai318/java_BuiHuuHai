package com.example.team1.repository.accounts;

import com.example.team1.model.accounts.Accounts;
import com.example.team1.repository.Base;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AccountRepository implements IAccountRepository {

    private static final String INSERT = "insert into accounts (account_email, account_username, account_password, account_create_date, role_id) values (?, ?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "select * from accounts where account_id = ?;";
    private static final String SELECT_ALL = "select * from accounts";
    private static final String DELETE = "update accounts set account_status = 1 where account_id = ?";
    private static final String UPDATE = "update accounts set account_password = ? where account_id = ?";
    private static final String FORGET_PASS = "update accounts set account_password = 123 where account_email = ?";

    @Override
    public void insertAccount(Accounts accounts) {
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, accounts.getEmail());
            preparedStatement.setString(2, accounts.getUsername());
            preparedStatement.setString(3, accounts.getPassword());
            preparedStatement.setString(4, accounts.getCreateDate());
            preparedStatement.setInt(5, accounts.getRole());
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
                String email = resultSet.getString("account_email");
                String username = resultSet.getString("account_username");
                String password = resultSet.getString("account_password");
                String createDate = resultSet.getString("account_create_date");
                int status = resultSet.getInt("account_status");
                int role = resultSet.getInt("role_id");
                accounts = new Accounts(id, email, username, password, createDate, status, role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accounts;
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
                String email = resultSet.getString("account_email");
                String username = resultSet.getString("account_username");
                String password = resultSet.getString("account_password");
                String createDate = resultSet.getString("account_create_date");
                int accountStatus = resultSet.getInt("account_status");
                int roleId = resultSet.getInt("role_id");
                accountsMap.put(username, new Accounts(id, email, username, password, createDate, accountStatus, roleId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accountsMap;
    }

    @Override
    public void deleteAccount(int id) {

    }

    @Override
    public void updateAccount(int id, Accounts accounts) {
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, accounts.getPassword());
            preparedStatement.setInt(2, accounts.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkLogin(String username, String password) {
        Accounts accounts = selectAllAccount().get(username);
        if (accounts != null) {
            if (accounts.isStatus() == 0) {
                return accounts.getPassword().equals(password);
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean checkAccount(String email, String username) {
        Accounts accounts1 = selectAllAccount().get(username);
        Accounts accounts2 = selectAllAccountByEmail().get(email);
        return accounts1 == null && accounts2 == null;
    }

    @Override
    public void forgetPass(String email) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FORGET_PASS);
            preparedStatement.setString(1, email);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, Accounts> selectAllAccountByEmail() {
        Map<String, Accounts> accountsMap = new HashMap<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("account_id");
                String email = resultSet.getString("account_email");
                String username = resultSet.getString("account_username");
                String password = resultSet.getString("account_password");
                String createDate = resultSet.getString("account_create_date");
                int accountStatus = resultSet.getInt("account_status");
                int roleId = resultSet.getInt("role_id");
                accountsMap.put(email, new Accounts(id, email, username, password, createDate, accountStatus, roleId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accountsMap;
    }
}
