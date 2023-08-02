package com.example.team1.model.order;

import com.example.team1.model.item.Items;

public class OrderDetail {
    private int id;
    private Items items;
    private int quantity;
    private int price;

    public OrderDetail(Items items, int quantity, int price) {
        this.items = items;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetail(int id, Items items, int quantity, int price) {
        this.id = id;
        this.items = items;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
