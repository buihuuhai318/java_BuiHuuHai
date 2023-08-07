package com.example.team1.repository.item;

import com.example.team1.model.item.Items;

import java.util.Map;

public interface IItemRepository {
    void insertItem(Items items);

    Items selectItem(int id);

    Map<Integer, Items> selectAllItem();

    Map<Integer, Items> selectAll();

    Map<Integer, Items> selectItemHot();

    Map<Integer, Items> searchItem(String searchKeyword);

    Map<Integer, Items> selectItemByType(int typeId);

    Map<String, Items> selectAllItemByCode();

    void availableItem(int id, boolean available);

    void updateItem(int id, Items items);

    void updateInventoryItem(int id, Items items);
}
