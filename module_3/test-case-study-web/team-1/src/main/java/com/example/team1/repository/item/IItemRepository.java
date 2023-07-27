package com.example.team1.repository.item;

import com.example.team1.model.item.Items;

import java.util.Map;

public interface IItemRepository {
    void insertItem(Items items);

    Items selectItem(int id);

    Map<Integer, Items> selectAllItem();

    void availableItem(int id, boolean available);

    void updateItem(int id, Items items);
}
