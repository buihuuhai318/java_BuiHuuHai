package com.example.team1.model.item;

public class ItemType {
    private int id;
    private String name;

    public ItemType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ItemType() {
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
}
