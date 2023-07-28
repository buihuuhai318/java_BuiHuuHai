package com.example.team1.service.item;

import com.example.team1.model.item.ItemType;
import com.example.team1.repository.item.IItemTypeRepository;
import com.example.team1.repository.item.ItemTypeRepository;

import java.util.Map;

public class ItemTypeService implements IItemTypeService {
    private final IItemTypeRepository itemTypeRepository = new ItemTypeRepository();

    @Override
    public ItemType selectItemType(int id) {
        return itemTypeRepository.selectItemType(id);
    }

    @Override
    public Map<Integer, ItemType> selectAllItemType() {
        return itemTypeRepository.selectAllItemType();
    }
}
