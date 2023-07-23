package com.example.team1.service.accounts;

import com.example.team1.model.accounts.Accounts;
import com.example.team1.repository.accounts.AccountRepository;
import com.example.team1.repository.accounts.IAccountRepository;

import java.util.Map;

public class AccountService implements IAccountService {
    private IAccountRepository accountRepository = new AccountRepository();

    @Override
    public void insertAccount(Accounts accounts) {
        accountRepository.insertAccount(accounts);
    }

    @Override
    public Accounts selectAccount(int id) {
        return accountRepository.selectAccount(id);
    }

    @Override
    public Map<String, Accounts> selectAllAccount() {
        return accountRepository.selectAllAccount();
    }

    @Override
    public void deleteAccount(int id) {

    }

    @Override
    public void updateAccount(int id, Accounts accounts) {

    }

    @Override
    public boolean checkLogin(String username, String password) {
        return accountRepository.checkLogin(username, password);
    }
}
