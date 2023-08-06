package com.example.team1.model.employee;

import com.example.team1.model.accounts.Accounts;

public class Employees {
    private int id;
    private String name;
    private int salary;
    private int gender;
    private String birthday;
    private String phone;
    private String address;
    private int status;
    private String image;
    private Accounts account;

    public Employees(int id, String name, int salary, int gender, String birthday, String phone, String address, int status, String image, Accounts account) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.image = image;
        this.account = account;
    }

    public Employees(String name, int salary, int gender, String birthday, String phone, String address, int status, String image, Accounts account) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.image = image;
        this.account = account;
    }

    public Employees(String name, int salary, int gender, String birthday, String phone, String address, String image, Accounts account) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.image = image;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getGender() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
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

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }
}
