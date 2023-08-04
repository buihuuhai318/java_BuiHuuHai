package com.example.team1.service.payment;

import com.example.team1.model.payment.Bill;
import com.example.team1.repository.payment.BillRepository;
import com.example.team1.repository.payment.IBillRepository;

import java.util.List;

public class BillService implements IBillService {

    private static final IBillRepository billRepository = new BillRepository();

    @Override
    public void insertBill(Bill bill) {
        billRepository.insertBill(bill);
    }

    @Override
    public Bill selectBill(int id) {
        return billRepository.selectBill(id);
    }

    @Override
    public List<Bill> selectAllByAccount(int id) {
        return billRepository.selectAllByAccount(id);
    }

    @Override
    public List<Bill> selectAll() {
        return billRepository.selectAll();
    }
}
