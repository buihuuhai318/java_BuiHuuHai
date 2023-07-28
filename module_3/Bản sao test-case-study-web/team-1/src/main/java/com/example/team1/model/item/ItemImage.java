package com.example.team1.model.item;

public class ItemImage {
    private int id;
    private String url;
    private Items items;

    public ItemImage(int id, String url, Items items) {
        this.id = id;
        this.url = url;
        this.items = items;
    }

    public ItemImage(String url) {
        this.url = url;
    }

    public ItemImage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
