package com.example.team1.model.accounts;

public class Roles {
    private int id;
    private String name;

    public static int ADMIN = 1;
    public static int EMPLOYEE = 2;
    public static int CUSTOMER = 3;

    public Roles(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Roles() {
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
