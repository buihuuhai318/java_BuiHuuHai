package com.example.team1.repository.accounts;

import com.example.team1.model.accounts.Accounts;

import java.util.Map;

public interface IAccountRepository {
    void insertAccount(Accounts accounts);

    Accounts selectAccount(int id);

    Map<String, Accounts> selectAllAccount();
    public Map<String, Accounts> selectAllAccountByEmail();

    void deleteAccount(int id);

    void updateAccount(int id, Accounts accounts);

    boolean checkLogin(String username, String password);

    boolean checkAccount(String email, String username);

    void forgetPass(String email);
}
