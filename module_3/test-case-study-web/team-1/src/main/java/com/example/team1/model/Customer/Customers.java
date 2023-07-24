package com.example.team1.model.Customer;

import com.example.team1.model.accounts.Accounts;

import java.time.LocalDate;
import java.util.Date;

public class Customers {
    private int id;
    private String name;
    private int gender;
    private String birthday;
    private String phone;
    private String email;
    private String address;
    private int status;
    private String image;
    private int type;
    private Accounts account;

    public Customers() {
    }

    public Customers(int id, String name, int gender, String birthday, String phone, String address, int status, String image, int type, Accounts account) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.email = account.getEmail();
        this.address = address;
        this.status = status;
        this.image = image;
        this.type = type;
        this.account = account;
    }

    public Customers(String name, int gender, String birthday, String phone, String address, String image, int type, Accounts account) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.email = account.getEmail();
        this.address = address;
        this.image = image;
        this.type = type;
        this.account = account;
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

    public int isGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }
}
