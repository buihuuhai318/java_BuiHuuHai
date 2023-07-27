package com.example.team1.repository.item;

import com.example.team1.model.item.ItemType;
import com.example.team1.repository.Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ItemTypeRepository implements IItemTypeRepository {
    private static final String SELECT_BY_ID = "select * from item_types where item_type_id = ?;";
    private static final String SELECT_ALL = "select * from item_types";

    @Override
    public ItemType selectItemType(int id) {
        ItemType itemType = null;
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("item_type_name");
                itemType = new ItemType(id, name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemType;
    }

    @Override
    public Map<Integer, ItemType> selectAllItemType() {
        Map<Integer, ItemType> typesMap = new HashMap<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("item_type_id");
                String name = resultSet.getString("item_type_name");
                typesMap.put(id, new ItemType(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typesMap;
    }
}
