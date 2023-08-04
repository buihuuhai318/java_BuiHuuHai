package com.example.team1.model.payment;

public class PaymentMethod {
    private int id;
    private String name;
    private int available;

    public PaymentMethod(int id, String name, int available) {
        this.id = id;
        this.name = name;
        this.available = available;
    }

    public PaymentMethod() {
    }

    public PaymentMethod(String name, int available) {
        this.name = name;
        this.available = available;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
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
