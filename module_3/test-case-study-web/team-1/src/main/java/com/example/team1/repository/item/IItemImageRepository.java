package com.example.team1.repository.item;

import com.example.team1.model.item.ItemImage;
import com.example.team1.model.item.Items;

import java.util.List;

public interface IItemImageRepository {
    void insertImage(ItemImage itemImage);

    void updateImage(int id, ItemImage itemImage);

    List<ItemImage> selectImageByItem(int id);

    void deleteImage(int id);

    void deleteImageByItem(int id);
}
