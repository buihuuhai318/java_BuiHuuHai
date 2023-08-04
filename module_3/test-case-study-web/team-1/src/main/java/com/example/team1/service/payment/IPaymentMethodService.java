package com.example.team1.service.payment;

import com.example.team1.model.payment.PaymentMethod;

import java.util.Map;

public interface IPaymentMethodService {
    Map<Integer, PaymentMethod> selectAll();

    Map<Integer, PaymentMethod> selectAllAvailable();

    void setAvailableMethod(int id, boolean available);

    PaymentMethod getPayment(int id);
}
