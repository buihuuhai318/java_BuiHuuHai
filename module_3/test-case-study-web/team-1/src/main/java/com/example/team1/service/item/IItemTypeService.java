package com.example.team1.service.item;

import com.example.team1.model.item.ItemType;

import java.util.Map;

public interface IItemTypeService {
    ItemType selectItemType(int id);

    Map<Integer, ItemType> selectAllItemType();
}
