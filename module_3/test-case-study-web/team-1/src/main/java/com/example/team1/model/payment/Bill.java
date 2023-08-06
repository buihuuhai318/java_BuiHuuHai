package com.example.team1.model.payment;

import com.example.team1.model.order.Cart;

import java.time.LocalDate;

public class Bill {
    private int id;
    private int cart;
    private PaymentMethod paymentMethod;
    private String date;
    private int totalQuantity;
    private int totalPrice;
    private String phone;
    private String address;
    private int paymentStatus;

    public Bill(int id, int cart, PaymentMethod paymentMethod, String date, int totalQuantity, int totalPrice, String phone, String address, int paymentStatus) {
        this.id = id;
        this.cart = cart;
        this.paymentMethod = paymentMethod;
        this.date = date;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.phone = phone;
        this.address = address;
        this.paymentStatus = paymentStatus;
    }

    public Bill(int cart, PaymentMethod paymentMethod, int totalQuantity, int totalPrice, String phone, String address, int paymentStatus) {
        this.cart = cart;
        this.paymentMethod = paymentMethod;
        this.date = String.valueOf(LocalDate.now());
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.phone = phone;
        this.address = address;
        this.paymentStatus = paymentStatus;
    }

    public Bill() {
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCart() {
        return cart;
    }

    public void setCart(int cart) {
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
