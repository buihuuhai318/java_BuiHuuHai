package com.example.team1.model.dto;

public class HotCustomer {
    private int id;
    private String username;
    private String name;
    private String type;
    private int totalBill;
    private int totalPrice;

    public HotCustomer(int id, String username, String name, String type, int totalBill, int totalPrice) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.type = type;
        this.totalBill = totalBill;
        this.totalPrice = totalPrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
