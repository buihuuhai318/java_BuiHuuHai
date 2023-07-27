package com.example.team1.repository.item;


import com.example.team1.model.item.ItemType;

import java.util.Map;

public interface IItemTypeRepository {
    ItemType selectItemType(int id);

    Map<Integer, ItemType> selectAllItemType();
}
