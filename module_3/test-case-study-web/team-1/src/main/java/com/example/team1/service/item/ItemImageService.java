package com.example.team1.service.item;

import com.example.team1.model.item.ItemImage;
import com.example.team1.repository.item.IItemImageRepository;
import com.example.team1.repository.item.ItemImageRepository;

import java.util.List;

public class ItemImageService implements IItemImageService {
    private final IItemImageRepository itemImageRepository = new ItemImageRepository();

    @Override
    public void insertImage(ItemImage itemImage) {
        itemImageRepository.insertImage(itemImage);
    }

    @Override
    public List<ItemImage> selectImageByItem(int id) {
        return itemImageRepository.selectImageByItem(id);
    }

    @Override
    public void deleteImage(int id) {
        itemImageRepository.deleteImage(id);
    }
}
