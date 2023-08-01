package com.example.team1.model.order;

import com.example.team1.model.accounts.Accounts;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Cart {
    private int id;
    private Accounts accounts;
    private String orderDate;
    private String paymentDate;
    private Map<Integer, OrderDetail> detailList;
    private int paymentStatus;

    public Cart(int id, Accounts accounts, String orderDate, String paymentDate, Map<Integer, OrderDetail> detailList, int paymentStatus) {
        this.id = id;
        this.accounts = accounts;
        this.orderDate = orderDate;
        this.paymentDate = paymentDate;
        this.detailList = detailList;
        this.paymentStatus = paymentStatus;
    }

    public Cart(Accounts accounts, String orderDate, String paymentDate, Map<Integer, OrderDetail> detailList, int paymentStatus) {
        this.accounts = accounts;
        this.orderDate = orderDate;
        this.paymentDate = paymentDate;
        this.detailList = detailList;
        this.paymentStatus = paymentStatus;
    }



    public Cart(Accounts accounts) {
        this.accounts = accounts;
        this.orderDate = String.valueOf(LocalDate.now());
        this.paymentStatus = 0;
    }

    public Map<Integer, OrderDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(Map<Integer, OrderDetail> detailList) {
        this.detailList = detailList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
