package com.example.team1.model.accounts;

import com.example.team1.repository.accounts.RoleRepository;

import java.time.LocalDate;

public class Accounts {

    private static RoleRepository roleRepository = new RoleRepository();

    public static final int CUSTOMER = 3;
    public static final int ADNIN = 1;
    public static final int EMPLOYEE = 2;
    private int id;
    private String email;
    private String username;
    private String password;
    private String createDate;
    private int availableAccount;
    private Roles role;

    public Accounts() {
    }

    public Accounts(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.createDate = String.valueOf(LocalDate.now());
        this.availableAccount = 0;
        this.role = roleRepository.selectRole(CUSTOMER);
    }

    public Accounts(String email, String username, String password, int availableAccount, Roles role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.createDate = String.valueOf(LocalDate.now());
        this.availableAccount = availableAccount;
        this.role = role;
    }

    public Accounts(String email, String username, String password, Roles role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.createDate = String.valueOf(LocalDate.now());
        this.availableAccount = 0;
        this.role = role;
    }

    public Accounts(int id, String email, String username, String password, String createDate, int available, Roles role) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.availableAccount = available;
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

    public int isAvailable() {
        return availableAccount;
    }

    public void setAvailable(int available) {
        this.availableAccount = available;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
