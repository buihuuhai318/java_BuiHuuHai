package repository;

import model.Bank;

import java.util.List;

public interface IBankRepository {
    List<Bank> listBank();

    void addNew(Bank bank);

    Bank getBank(int index);

    int searchByStk(long stk);
}
