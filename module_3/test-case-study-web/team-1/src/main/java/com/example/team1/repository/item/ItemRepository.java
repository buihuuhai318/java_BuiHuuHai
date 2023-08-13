package com.example.team1.repository.item;

import com.example.team1.model.item.ItemImage;
import com.example.team1.model.item.ItemType;
import com.example.team1.model.item.Items;
import com.example.team1.repository.Base;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemRepository implements IItemRepository {
    private static final String INSERT = "insert into items (item_code, item_name, item_price, item_inventory, item_description, item_available, item_type_id) values (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL = "select * from items";
    private static final String DELETE = "update items set item_available = 1 where item_id = ?";
    private static final String AVAILABLE = "update items set item_available = 0 where item_id = ?";
    private static final String UPDATE = "update items set " +
            "item_code = ?, " +
            "item_name = ?, " +
            "item_price = ?, " +
            "item_inventory = ?, " +
            "item_description = ?, " +
            "item_available = ?, " +
            "item_type_id = ? " +
            "where item_id = ?";

    private static final String UPDATE_INVENTORY = "update items set " +
            "item_inventory = ? " +
            "where item_id = ?";

    private static final String HOT_SALE = "call hot_sale;";

    private static final String SEARCH = "call search_items(?);";

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
            preparedStatement.setString(5, items.getDescription());
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
        return selectAll().get(id);
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
                String description = resultSet.getString("item_description");
                int available = resultSet.getInt("item_available");
                int typeId = resultSet.getInt("item_type_id");

                List<ItemImage> imageList = itemImageRepository.selectImageByItem(id);
                ItemType itemType = itemTypeRepository.selectItemType(typeId);

                if (available == 0) {
                    itemsMap.put(id, new Items(id, code, name, price, inventory, available, description, imageList, itemType));
                }
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemsMap;
    }

    @Override
    public Map<Integer, Items> selectAll() {
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
                String description = resultSet.getString("item_description");
                int available = resultSet.getInt("item_available");
                int typeId = resultSet.getInt("item_type_id");

                List<ItemImage> imageList = itemImageRepository.selectImageByItem(id);
                ItemType itemType = itemTypeRepository.selectItemType(typeId);
                itemsMap.put(id, new Items(id, code, name, price, inventory, available, description, imageList, itemType));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemsMap;
    }

    @Override
    public Map<Integer, Items> selectItemHot() {
        Map<Integer, Items> itemsMap = new HashMap<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(HOT_SALE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("item_id");
                int typeId = resultSet.getInt("item_type_id");
                Items items = selectItem(id);
                List<ItemImage> imageList = itemImageRepository.selectImageByItem(id);
                ItemType itemType = itemTypeRepository.selectItemType(typeId);
                items.setItemType(itemType);
                items.setImageList(imageList);
                itemsMap.put(id, items);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemsMap;
    }

    @Override
    public Map<Integer, Items> searchItem(String searchKeyword) {
        Map<Integer, Items> itemsMap = new HashMap<>();
        Connection connection = Base.getConnection();

        try {
            CallableStatement callableStatement = connection.prepareCall(SEARCH);
            callableStatement.setString(1, searchKeyword);
            callableStatement.executeUpdate();
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("item_id");
                int typeId = resultSet.getInt("item_type_id");
                Items items = selectItem(id);
                List<ItemImage> imageList = itemImageRepository.selectImageByItem(id);
                ItemType itemType = itemTypeRepository.selectItemType(typeId);
                items.setItemType(itemType);
                items.setImageList(imageList);
                if (items.getAvailable() == 0) {
                    itemsMap.put(id, items);
                }
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemsMap;
    }

    @Override
    public Map<Integer, Items> selectItemByType(int typeId) {
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
                String description = resultSet.getString("item_description");
                int available = resultSet.getInt("item_available");
                int typeIdTemp = resultSet.getInt("item_type_id");

                List<ItemImage> imageList = itemImageRepository.selectImageByItem(id);
                ItemType itemType = itemTypeRepository.selectItemType(typeIdTemp);

                if (typeId == typeIdTemp) {
                    itemsMap.put(id, new Items(id, code, name, price, inventory, available, description, imageList, itemType));
                }
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemsMap;
    }

    @Override
    public Map<String, Items> selectAllItemByCode() {
        Map<String, Items> itemsMap = new HashMap<>();
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
                String description = resultSet.getString("item_description");
                int available = resultSet.getInt("item_available");
                int typeId = resultSet.getInt("item_type_id");

                List<ItemImage> imageList = itemImageRepository.selectImageByItem(id);
                ItemType itemType = itemTypeRepository.selectItemType(typeId);

                itemsMap.put(code, new Items(id, code, name, price, inventory, available, description, imageList, itemType));
            }
            resultSet.close();
            connection.close();
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
    public void updateItem(int id, Items items) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, items.getCode());
            preparedStatement.setString(2, items.getName());
            preparedStatement.setInt(3, items.getPrice());
            preparedStatement.setInt(4, items.getInventory());
            preparedStatement.setString(5, items.getDescription());
            preparedStatement.setInt(6, items.getAvailable());
            preparedStatement.setInt(7, items.getItemType().getId());
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateInventoryItem(int id, Items items) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_INVENTORY);
            preparedStatement.setInt(1, items.getInventory());
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
