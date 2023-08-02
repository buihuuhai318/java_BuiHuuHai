package com.example.team1.model.item;

import java.util.List;

public class Items {
    private int id;
    private String code;
    private String name;
    private int price;
    private int inventory;
    private int available;
    private String decreption;
    List<ItemImage> imageList;
    ItemType itemType;

    public Items(int id, String code, String name, int price, int inventory, int available, String decreption, List<ItemImage> imageList, ItemType itemType) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.available = available;
        this.decreption = decreption;
        this.imageList = imageList;
        this.itemType = itemType;
    }

    public Items(String code, String name, int price, int inventory, int available, String decreption, List<ItemImage> imageList, ItemType itemType) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.available = available;
        this.decreption = decreption;
        this.imageList = imageList;
        this.itemType = itemType;
    }

    public Items(String code, String name, int price, int inventory, int available, String decreption, ItemType itemType) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.available = available;
        this.decreption = decreption;
        this.itemType = itemType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getDecreption() {
        return decreption;
    }

    public void setDecreption(String decreption) {
        this.decreption = decreption;
    }

    public List<ItemImage> getImageList() {
        return imageList;
    }

    public void setImageList(List<ItemImage> imageList) {
        this.imageList = imageList;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
