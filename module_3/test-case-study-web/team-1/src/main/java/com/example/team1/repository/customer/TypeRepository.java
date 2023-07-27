package com.example.team1.repository.customer;

import com.example.team1.model.customers.Types;
import com.example.team1.repository.Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TypeRepository implements ITypeRepository {

    private static final String SELECT_BY_ID = "select * from customer_types where customer_type_id = ?;";
    private static final String SELECT_ALL = "select * from customer_types";

    @Override
    public Types selectType(int id) {
        Types types = null;
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("customer_type_name");
                types = new Types(id, name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return types;
    }

    @Override
    public Map<Integer, Types> selectAllType() {
        Map<Integer, Types> typesMap = new HashMap<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_type_name");
                typesMap.put(id, new Types(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typesMap;
    }
}
