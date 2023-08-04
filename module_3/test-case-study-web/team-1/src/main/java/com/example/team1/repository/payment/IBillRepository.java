package com.example.team1.repository.payment;


import com.example.team1.model.payment.Bill;

import java.util.List;

public interface IBillRepository {
    void insertBill(Bill bill);

    Bill selectBill(int id);

    List<Bill> selectAllByAccount(int id);

    List<Bill> selectAll();
}
