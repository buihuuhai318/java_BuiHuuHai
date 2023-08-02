package com.example.team1.service.item;

import com.example.team1.model.item.ItemType;
import com.example.team1.model.item.Items;

import java.util.Map;

public interface IItemService {
    void insertItem(Items items);

    Items selectItem(int id);

    Map<Integer, Items> selectAllItem();

    Map<String, Items> selectAllItemByCode();

    void availableItem(int id, boolean available);

    void updateItem(int id, Items items);

    Map<Integer, Items> selectItemHot();

    Map<Integer, Items> selectItemByType(int typeId);

    void updateInventoryItem(int id, Items items);

    Map<Integer, Items> searchItem(String searchKeyword);
}
