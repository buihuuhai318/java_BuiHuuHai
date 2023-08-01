package com.example.user_manager.repository;

import com.example.user_manager.model.Users;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String INSERT = "call insert_data(?, ?, ?)";
    private static final String SELECT_BY_ID = "select id, name, email, country from users where id = ?";
    private static final String SELECT_ALL = "call select_all()";
    private static final String DELETE = "call delete_data(?)";
    private static final String UPDATE = "call edit_data(?, ?, ?, ?)";

    @Override
    public void insertUser(Users users) {
        Connection connection = Base.getConnection();
        try {
            connection.setAutoCommit(false);
            CallableStatement callableStatement = connection.prepareCall(INSERT);
            callableStatement.setString(1, users.getName());
            callableStatement.setString(2, users.getEmail());
            callableStatement.setString(3, users.getCountry());
            callableStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public Users selectUser(int id) {
        Users users = null;
        Connection connection = Base.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users = new Users(id, name, email, country);
            }
            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<Users> selectAllUsers() {
        List<Users> users = new ArrayList<>();
        Connection connection = Base.getConnection();
        try {
            connection.setAutoCommit(false);
            CallableStatement callableStatement = connection.prepareCall(SELECT_ALL);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new Users(id, name, email, country));
            }
            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void deleteUsers(int id) {
        Connection connection = Base.getConnection();
        try {
            connection.setAutoCommit(false);
            CallableStatement callableStatement = connection.prepareCall(DELETE);
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUsers(int id, Users users) {
        Connection connection = Base.getConnection();
        try {
            connection.setAutoCommit(false);
            CallableStatement callableStatement = connection.prepareCall(UPDATE);
            callableStatement.setInt(1, id);
            callableStatement.setString(2, users.getName());
            callableStatement.setString(3, users.getEmail());
            callableStatement.setString(4, users.getCountry());
            callableStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }
}
