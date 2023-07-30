package com.example.team1.repository.accounts;

import com.example.team1.model.accounts.Roles;
import com.example.team1.repository.Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RoleRepository implements IRoleRepository {

    private static final String SELECT_BY_ID = "select * from roles where role_id = ?;";
    private static final String SELECT_ALL = "select * from roles";

    @Override
    public Roles selectRole(int id) {
        Roles roles = null;
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("role_name");
                roles = new Roles(id, name);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roles;
    }

    @Override
    public Map<Integer, Roles> selectAllRole() {
        Map<Integer, Roles> rolesMap = new HashMap<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("role_id");
                String name = resultSet.getString("role_name");
                rolesMap.put(id, new Roles(id, name));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rolesMap;
    }
}
