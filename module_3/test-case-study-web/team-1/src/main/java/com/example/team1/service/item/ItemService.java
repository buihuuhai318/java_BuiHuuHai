package com.example.team1.service.item;

import com.example.team1.model.item.ItemType;
import com.example.team1.model.item.Items;
import com.example.team1.repository.item.IItemRepository;
import com.example.team1.repository.item.ItemRepository;

import java.util.Map;

public class ItemService implements IItemService {
    private final IItemRepository itemRepository = new ItemRepository();

    @Override
    public void insertItem(Items items) {
        itemRepository.insertItem(items);
    }

    @Override
    public Items selectItem(int id) {
        return itemRepository.selectItem(id);
    }

    @Override
    public Map<Integer, Items> selectAllItem() {
        return itemRepository.selectAllItem();
    }

    @Override
    public Map<String, Items> selectAllItemByCode() {
        return itemRepository.selectAllItemByCode();
    }

    @Override
    public void availableItem(int id, boolean available) {
        itemRepository.availableItem(id, available);
    }

    @Override
    public void updateItem(int id, Items items) {
        itemRepository.updateItem(id, items);
    }

    @Override
    public Map<Integer, Items> selectItemHot() {
        return itemRepository.selectItemHot();
    }

    @Override
    public Map<Integer, Items> selectItemByType(int typeId) {
        return itemRepository.selectItemByType(typeId);
    }
}
