package com.example.team1.service.accounts;

import com.example.team1.model.accounts.Accounts;

import java.util.Map;

public interface IAccountService {
    void insertAccount(Accounts accounts);

    Accounts selectAccount(int id);

    Map<String, Accounts> selectAllAccount();
    public Map<String, Accounts> selectAllAccountByEmail();

    void setAvailableAccount(int id, boolean available);

    void updateAccount(int id, Accounts accounts);

    boolean checkLogin(String username, String password);

    boolean checkAccount(String email, String username);

    void forgetPass(String email, String newPass);
}
