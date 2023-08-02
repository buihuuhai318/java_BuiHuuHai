package com.example.team1.model.dto;

public class BillDto {
    private int accountId;
    private int cartId;
    private int billId;
    private String date;
    private int quantity;
    private int total;

    public BillDto(int accountId, int cartId, int billId, String date, int quantity, int total) {
        this.accountId = accountId;
        this.cartId = cartId;
        this.billId = billId;
        this.date = date;
        this.quantity = quantity;
        this.total = total;
    }

    public BillDto() {
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
