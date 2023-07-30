package com.example.team1.service.item;

import com.example.team1.model.item.ItemImage;

import java.util.List;

public interface IItemImageService {
    void insertImage(ItemImage itemImage);

    List<ItemImage> selectImageByItem(int id);

    void deleteImage(int id);

    void deleteImageByItem(int id);

    void updateImage(int id, ItemImage itemImage);
}
