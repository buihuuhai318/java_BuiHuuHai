package com.example.team1.model.accounts;

import java.time.LocalDate;

public class Accounts {

    private static final int ADMIN = 1;
    private static final int EMPLOYEE = 2;
    private static final int CUSTOMER = 3;
    private int id;
    private String email;
    private String username;
    private String password;
    private String createDate;
    private int status;
    private int role;

    public Accounts() {
    }

    public Accounts(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.createDate = String.valueOf(LocalDate.now());
        this.status = 0;
        this.role = CUSTOMER;
    }

    public Accounts(String email, String username, String password, int role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.createDate = String.valueOf(LocalDate.now());
        this.status = 0;
        this.role = role;
    }

    public Accounts(int id, String email, String username, String password, String createDate, int status, int role) {
        this.id = id;
        this.email = email;
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

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
