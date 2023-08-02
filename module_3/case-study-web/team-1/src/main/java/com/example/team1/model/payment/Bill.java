package com.example.team1.model.payment;

import com.example.team1.model.order.Cart;

import java.time.LocalDate;

public class Bill {
    private int id;
    private Cart cart;
    private PaymentMethod paymentMethod;
    private String date;
    private int totalPrice;
    private String phone;
    private String address;

    public Bill(int id, Cart cart, PaymentMethod paymentMethod, String date, int totalPrice, String phone, String address) {
        this.id = id;
        this.cart = cart;
        this.paymentMethod = paymentMethod;
        this.date = date;
        this.totalPrice = totalPrice;
        this.phone = phone;
        this.address = address;
    }

    public Bill(Cart cart, PaymentMethod paymentMethod, int totalPrice, String phone, String address) {
        this.cart = cart;
        this.paymentMethod = paymentMethod;
        this.date = String.valueOf(LocalDate.now());;
        this.totalPrice = totalPrice;
        this.phone = phone;
        this.address = address;
    }

    public Bill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
