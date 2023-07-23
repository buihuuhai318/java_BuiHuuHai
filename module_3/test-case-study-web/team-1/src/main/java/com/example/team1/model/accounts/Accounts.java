package com.example.team1.model.accounts;

import java.time.LocalDate;

public class Accounts {

    private static final int ADMIN = 1;
    private static final int EMPLOYEE = 2;
    private static final int CUSTOMER = 3;
    private int id;
    private String username;
    private String password;
    private String createDate;
    private boolean status;
    private int role;

    public Accounts() {
    }

    public Accounts(String username, String password) {
        this.username = username;
        this.password = password;
        this.createDate = String.valueOf(LocalDate.now());
        this.status = false;
        this.role = CUSTOMER;
    }

    public Accounts(int id, String username, String password, String createDate, boolean status, int role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.status = status;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
