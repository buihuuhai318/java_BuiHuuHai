package com.example.team1.model.customers;

public class Types {
    private int id;
    private String name;

    public static int DIAMOND = 1;
    public static int GOLD = 2;
    public static int SLIVER = 3;

    public Types(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Types() {
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
