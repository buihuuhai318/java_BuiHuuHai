package com.example.team1.service.payment;

import com.example.team1.model.payment.Bill;
import com.example.team1.repository.payment.BillRepository;
import com.example.team1.repository.payment.IBillRepository;

public class BillService implements IBillService {

    private static final IBillRepository billRepository = new BillRepository();

    @Override
    public void insertBill(Bill bill) {
        billRepository.insertBill(bill);
    }
}
