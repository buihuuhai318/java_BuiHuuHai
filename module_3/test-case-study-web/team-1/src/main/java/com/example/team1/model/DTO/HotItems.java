package com.example.team1.model.dto;

public class HotItems {
    private int id;
    private String name;
    private String type;
    private int totalQuantity;
    private int totalPrice;

    public HotItems(int id, String name, String type, int totalQuantity, int totalPrice) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
