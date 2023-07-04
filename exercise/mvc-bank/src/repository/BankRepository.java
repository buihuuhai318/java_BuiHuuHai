package repository;

import model.Bank;
import utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class BankRepository implements IBankRepository {

    @Override
    public List<Bank> listBank() {
        List<String> stringList = ReadAndWrite.read(ReadAndWrite.PATH_FILE);
        List<Bank> bankList = new ArrayList<>();
        for (String line : stringList) {
            String[] info = line.split(",");
            bankList.add(new Bank(Long.parseLong(info[0]), info[1], Double.parseDouble(info[2])));
        }
        return bankList;
    }

    @Override
    public void addNew(Bank bank) {
        List<String> stringList = ReadAndWrite.read(ReadAndWrite.PATH_FILE);
        stringList.add(bank.toFile());
        ReadAndWrite.write(ReadAndWrite.PATH_FILE, stringList, false);
    }

    @Override
    public Bank getBank(int index) {
        List<Bank> bankList = listBank();
        return bankList.get(index);
    }

    @Override
    public int searchByStk(long stk) {
        List<Bank> bankList = listBank();
        for (int i = 0; i < bankList.size(); i++) {
            if (bankList.get(i).getStk() == stk) {
                return i;
            }
        }
        return -1;
    }
}
