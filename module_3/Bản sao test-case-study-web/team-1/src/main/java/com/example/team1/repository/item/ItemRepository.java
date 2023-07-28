package com.example.team1.repository.item;

import com.example.team1.model.item.ItemImage;
import com.example.team1.model.item.ItemType;
import com.example.team1.model.item.Items;
import com.example.team1.repository.Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemRepository implements IItemRepository {
    private static final String INSERT = "insert into items (item_code, item_name, item_price, item_inventory, item_decreption, item_available, item_type_id) values (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL = "select * from items";
    private static final String DELETE = "update items set item_available = 1 where item_id = ?";
    private static final String AVAILABLE = "update items set item_available = 0 where item_id = ?";
    private static final String UPDATE = "update items set " +
            "item_code = ?, " +
            "item_name = ?, " +
            "item_price = ?, " +
            "item_inventory = ?, " +
            "item_decreption = ?, " +
            "item_available = ?, " +
            "item_type_id = ?" +
            "where item_id = ?";

    private final IItemImageRepository itemImageRepository = new ItemImageRepository();

    private final IItemTypeRepository itemTypeRepository = new ItemTypeRepository();

    @Override
    public void insertItem(Items items) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, items.getCode());
            preparedStatement.setString(2, items.getName());
            preparedStatement.setInt(3, items.getPrice());
            preparedStatement.setInt(4, items.getInventory());
            preparedStatement.setString(5, items.getDecreption());
            preparedStatement.setInt(6, items.getAvailable());
            preparedStatement.setInt(7, items.getItemType().getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Items selectItem(int id) {
        return selectAllItem().get(id);
    }

    @Override
    public Map<Integer, Items> selectAllItem() {
        Map<Integer, Items> itemsMap = new HashMap<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("item_id");
                String code = resultSet.getString("item_code");
                String name = resultSet.getString("item_name");
                int price = resultSet.getInt("item_price");
                int inventory = resultSet.getInt("item_inventory");
                String decreption = resultSet.getString("item_decreption");
                int available = resultSet.getInt("item_available");
                int typeId = resultSet.getInt("item_type_id");

                List<ItemImage> imageList = itemImageRepository.selectImageByItem(id);
                ItemType itemType = itemTypeRepository.selectItemType(typeId);

                itemsMap.put(id, new Items(code, name, price, inventory, available, decreption, imageList, itemType));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemsMap;
    }

    @Override
    public void availableItem(int id, boolean available) {
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
    public void updateItem(int id, Items items) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, items.getCode());
            preparedStatement.setString(2, items.getName());
            preparedStatement.setInt(3, items.getPrice());
            preparedStatement.setInt(4, items.getInventory());
            preparedStatement.setString(5, items.getDecreption());
            preparedStatement.setInt(6, items.getAvailable());
            preparedStatement.setInt(7, items.getItemType().getId());
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
